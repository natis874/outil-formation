package org.tamyass.outilformation.dto;

import lombok.*;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SkillDTO {
    private Long id;
    private String name;
    private Long categoryId;
    private String categoryName;
    private Integer aiLevel;
    private Long userId;
    private List<AssessmentQuestionDTO> questions;


}
