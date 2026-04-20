package org.tamyass.outilformation.dto;

import lombok.*;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SkillDTO {
    private Long id;
    private String name;
    private Long categoryId;
    private String categoryName;
    private Integer aiLevel;
    private Integer selfLevel;
    private Long userId;
    private List<AssessmentQuestionDTO> questions;


}
