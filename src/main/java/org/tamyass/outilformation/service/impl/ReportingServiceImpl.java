package org.tamyass.outilformation.service.impl;

import org.springframework.stereotype.Service;
import org.tamyass.outilformation.dto.report.MindMapDTO;

import org.tamyass.outilformation.dto.SkillDTO;
import org.tamyass.outilformation.dto.report.TextReportDTO;
import org.tamyass.outilformation.entities.Skill;

import org.tamyass.outilformation.mapper.SkillMapper;
import org.tamyass.outilformation.repository.CategoryRepository;
import org.tamyass.outilformation.repository.SkillRepository;
import org.tamyass.outilformation.repository.UserRepository;
import org.tamyass.outilformation.service.ReportingService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportingServiceImpl implements ReportingService {


    private final SkillRepository skillRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final SkillMapper skillMapper;

    public ReportingServiceImpl(SkillRepository skillRepository,
                                UserRepository userRepository,
                                CategoryRepository categoryRepository,
                                SkillMapper skillMapper) {
        this.skillRepository = skillRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.skillMapper = skillMapper;
    }

    @Override
    public List<MindMapDTO> getMindMap(Long userId) {
        List<Skill> allSkills = skillRepository.findByUserId(userId);

        return allSkills.stream()
                .collect(Collectors.groupingBy(skill -> skill.getCategory().getName()))
                .entrySet()
                .stream()
                .map(entry -> MindMapDTO.builder()
                        .CategoryName(entry.getKey())
                        .skills(
                                entry.getValue().stream()
                                        .map(skillMapper::toDTO)
                                        .toList()
                        )
                        .build()
                )
                .toList();
    }

    @Override
    public TextReportDTO getTextReport(Long userId) {
        List<Skill> skills = skillRepository.findByUserId(userId);
        List<SkillDTO> skillDTOS = skills
                .stream()
                .map(skillMapper::toDTO)
                .toList();
        long validatedCount = skills.stream()
                .filter(s->s.getAiLevel() != null && s.getSelfLevel() != null && s.getAiLevel().equals(s.getSelfLevel()))
                .count();
        String synthesis = String.format("Analyse terliné : %d compétence %d correspondent exactement à votre auto-évaluation",validatedCount,skills.size());
        return TextReportDTO.builder()
                .globalSynthesis(synthesis)
                .skills(skillDTOS)
                .generationDate(LocalDateTime.now())
                .build();
    }
}
