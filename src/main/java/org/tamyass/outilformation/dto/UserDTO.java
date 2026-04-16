package org.tamyass.outilformation.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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
    // Validation (Jakarta)
    @NotBlank(message = "Le nom est obligatoire")
    private String nom;
    @Email(message = "Email invalide")
    @NotBlank(message = "L'email est obligatoire")
    private String email;
    private LocalDateTime createdAt;
    private List<SkillDTO> skills;

}
