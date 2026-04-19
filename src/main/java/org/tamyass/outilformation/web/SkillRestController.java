package org.tamyass.outilformation.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tamyass.outilformation.dto.SkillDTO;
import org.tamyass.outilformation.entities.Skill;
import org.tamyass.outilformation.service.SkillService;

import java.util.List;

@RestController
@RequestMapping("/api/skill")
public class SkillRestController {

    private final SkillService skillService;

    public SkillRestController(SkillService skillService) {
        this.skillService = skillService;
    }
    public ResponseEntity<List<Skill>> getSkillsByUser(@PathVariable Long userId) {
        return null;
    }
    public ResponseEntity<SkillDTO> updqteEstimation(@PathVariable Long skillId, @RequestBody Integer level) {
        return null;
    }
    public ResponseEntity<List<Skill>> getSkillByCategoryId(@PathVariable Long categoryId) {
        return null;
    }

}
