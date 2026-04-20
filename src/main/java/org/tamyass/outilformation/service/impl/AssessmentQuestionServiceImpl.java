package org.tamyass.outilformation.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.tamyass.outilformation.dto.AssessmentQuestionDTO;
import org.tamyass.outilformation.dto.SkillDTO;
import org.tamyass.outilformation.entities.AssessmentQuestion;
import org.tamyass.outilformation.entities.Skill;
import org.tamyass.outilformation.mapper.AssessmentQuestionMapper;
import org.tamyass.outilformation.mapper.SkillMapper;
import org.tamyass.outilformation.repository.AssessmentQuestionRepository;
import org.tamyass.outilformation.repository.SkillRepository;
import org.tamyass.outilformation.service.AssessmentQuestionService;

import java.util.ArrayList;
import java.util.List;

@Service
public class AssessmentQuestionServiceImpl implements AssessmentQuestionService {

    private final AssessmentQuestionRepository assessmentQuestionRepository;
    private final SkillRepository skillRepository;
    private final AssessmentQuestionMapper assessmentQuestionMapper;
    private final SkillMapper skillMapper;

    public AssessmentQuestionServiceImpl(AssessmentQuestionRepository assessmentQuestionRepository, SkillRepository skillRepository, AssessmentQuestionMapper assessmentQuestionMapper, SkillMapper skillMapper) {
        this.assessmentQuestionRepository = assessmentQuestionRepository;
        this.skillRepository = skillRepository;
        this.assessmentQuestionMapper = assessmentQuestionMapper;
        this.skillMapper = skillMapper;
    }

    @Override
    public List<AssessmentQuestionDTO> generateQuestionBySkillId(Long skillId) {
        Skill skill = skillRepository.findById(skillId)
                .orElseThrow(()-> new EntityNotFoundException("Compétence non trouvée"));
        assessmentQuestionRepository.deleteAssessmentQuestionBySkillId(skillId);
        List<AssessmentQuestion> newQuestions = new ArrayList<>();
        for(int i=0;i<=3;i++){
            AssessmentQuestion q = AssessmentQuestion.builder()
                    .enonce("Contexte de la question"+i)
                    .questionText("Question générée par l'IA sur "+skill.getName())
                    .skill(skill)
                    .build();
            newQuestions.add(q);
        }
        return assessmentQuestionRepository.saveAll(newQuestions)
                .stream()
                .map(q->new AssessmentQuestionDTO(q.getId(),q.getEnonce(),q.getQuestionText(),null,skillId))
                .toList();
    }

    @Override
    public List<AssessmentQuestionDTO> getQuestionsBySkillId(Long skillId) {
        return assessmentQuestionRepository.findAssessmentQuestionBySkillId(skillId)
                .stream()
                .map(q->new AssessmentQuestionDTO(q.getId(),q.getEnonce(),q.getQuestionText(),q.getAnswerText(),skillId))
                .toList();
    }

    @Override
    public SkillDTO submitAassessment(Long skillId, List<AssessmentQuestionDTO> answers) {
        Skill skill = skillRepository.findById(skillId)
                .orElseThrow(()-> new EntityNotFoundException("Compétence non trouvée"));
        for (AssessmentQuestionDTO dto:answers){
            AssessmentQuestion q = assessmentQuestionRepository.findById(dto.getId())
                    .orElseThrow();
            q.setAnswerText(dto.getAnswerText());
            assessmentQuestionRepository.save(q);
        }
        // mock avant intégration de IA
        Integer calculatedLeve = 4;
        skill.setSelfLevel(calculatedLeve);
        Skill updateskill = skillRepository.save(skill);
        return skillMapper.toDTO(updateskill);
    }
}
