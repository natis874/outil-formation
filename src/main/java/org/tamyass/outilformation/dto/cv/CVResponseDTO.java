package org.tamyass.outilformation.dto.cv;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CVResponseDTO {
    private List<CVSkillDTO> skills;
}
