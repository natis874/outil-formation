package org.tamyass.outilformation.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tamyass.outilformation.dto.SkillDTO;
import org.tamyass.outilformation.entities.Skill;
import org.tamyass.outilformation.service.SkillService;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor // pour faire les contructeurs des services
public class SkillRestController {

    private final SkillService skillService;

    @GetMapping("/user/{userId}/skills)")
    public ResponseEntity<List<SkillDTO>> getSkillsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(skillService.getSkillsbyUserId(userId));
    }
    @PatchMapping("/skills/{skillId}/estimation")
    public ResponseEntity<SkillDTO> updqteEstimation(@PathVariable Long skillId, @RequestBody Integer level) {
        return ResponseEntity.ok(skillService.UpdateEstimation(skillId,level));
    }
    @GetMapping("/categories/{categoryId}/skills")
    public ResponseEntity<List<SkillDTO>> getSkillByCategoryId(@PathVariable Long categoryId) {
        return ResponseEntity.ok(skillService.getSkillByCategoryId(categoryId));
    }

}
