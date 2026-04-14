package org.tamyass.outilformation.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDTO {
    private Long id;
    private String nom;
    private String email;
    private LocalDateTime createdAt;
    private List<SkillDTO> skills;

}
