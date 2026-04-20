package org.tamyass.outilformation.dto.report;

import lombok.*;
import org.tamyass.outilformation.dto.SkillDTO;

import java.time.LocalDateTime;
import java.util.List;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
// en format text
public class TextReportDTO {
    private String globalSynthesis;
    private List<SkillDTO> skills;
    private LocalDateTime generationDate;
}
