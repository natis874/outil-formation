package org.tamyass.outilformation.dto.cv;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CVSkillDTO {
    private String name;
    private String categoryName;
}
