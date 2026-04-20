package org.tamyass.outilformation.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AssessmentQuestionDTO {

    private Long id;
    private String enonce;
    private String questionText;
    private String answerText;
    private Long skillId;

}
