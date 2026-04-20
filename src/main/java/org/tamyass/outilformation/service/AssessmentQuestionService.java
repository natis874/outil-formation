package org.tamyass.outilformation.service;

import org.tamyass.outilformation.dto.AssessmentQuestionDTO;
import org.tamyass.outilformation.dto.SkillDTO;

import java.util.List;

public interface AssessmentQuestionService {
    List<AssessmentQuestionDTO> generateQuestionBySkillId(Long skillId);
    List<AssessmentQuestionDTO> getQuestionsBySkillId(Long skillId);
    SkillDTO submitAassessment(Long skillId,List<AssessmentQuestionDTO> answers);
}
