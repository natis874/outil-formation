package org.tamyass.outilformation.mapper;

import org.mapstruct.Mapper;
import org.tamyass.outilformation.dto.AssessmentQuestionDTO;
import org.tamyass.outilformation.entities.AssessmentQuestion;


@Mapper(componentModel = "spring")
public interface AssessmentQuestionMapper {
    AssessmentQuestionDTO toDTO(AssessmentQuestion assessmentQuestion);
    AssessmentQuestion toEntity(AssessmentQuestionDTO assessmentQuestionDTO);
}
