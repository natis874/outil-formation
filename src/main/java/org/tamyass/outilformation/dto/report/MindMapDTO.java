package org.tamyass.outilformation.dto.report;

import lombok.*;
import org.tamyass.outilformation.dto.SkillDTO;

import java.util.List;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
// une structure hiérarchisé pour corrspondre au visuel
public class MindMapDTO {
    private String CategoryName;
    private List<SkillDTO> skills;
}
