package org.tamyass.outilformation.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.tamyass.outilformation.dto.SkillDTO;
import org.tamyass.outilformation.entities.Skill;
import org.tamyass.outilformation.mapper.SkillMapper;
import org.tamyass.outilformation.repository.SkillRepository;
import org.tamyass.outilformation.service.SkillService;

import java.util.List;
@Service
@RequiredArgsConstructor // pour injecter proprement  des repositories et mappers
public class SkillServiceImpl implements SkillService {

    private final SkillRepository skillRepository;

    private final SkillMapper skillMapper;


    @Override
    public List<SkillDTO> getSkillsbyUserId(Long userId) {
        return skillRepository.findByUserId(userId)
                .stream()
                .map(skillMapper::toDTO)
                .toList();
    }

    @Override
    public SkillDTO UpdateEstimation(Long skillId, Integer level) {
        if (level < 1 || level > 5) {
            throw new IllegalArgumentException("Le niveau doit etre compris entre 1 et 5 : ");
        }
        System.out.println(level);
        Skill skill = skillRepository.findById(skillId)
                .orElseThrow(()-> new EntityNotFoundException("Competence non trouvee"));
        skill.setSelfLevel(level);
        skillRepository.save(skill);
        return skillMapper.toDTO(skill);
    }

    @Override
    public List<SkillDTO> getSkillByCategoryId(Long categoryId) {
        return skillRepository.findByCategoryId(categoryId)
                .stream()
                .map(skillMapper::toDTO)
                .toList();
    }
}
