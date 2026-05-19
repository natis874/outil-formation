package org.tamyass.outilformation.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.tamyass.outilformation.dto.SkillDTO;
import org.tamyass.outilformation.dto.cv.CVResponseDTO;
import org.tamyass.outilformation.dto.cv.CVSkillDTO;
import org.tamyass.outilformation.service.CVService;

import java.util.List;

@RestController
@RequestMapping("/api/cv")
@RequiredArgsConstructor // pour faire les contructeurs des services
public class CVRestContoller {
    private final CVService cvService;

    @PostMapping("/extract")
    public ResponseEntity<CVResponseDTO> extractSkills(@RequestParam("file") MultipartFile file){
        return ResponseEntity.ok(cvService.extractSkillFromCV(file));
    }
    @PostMapping("/user/{userId}/save")
    public ResponseEntity<List<SkillDTO>> saveSkills(
            @PathVariable Long userId,
            @RequestBody List<CVSkillDTO> skills
    ){
        return ResponseEntity.ok(cvService.saveSkills(userId,skills));
    }
}
