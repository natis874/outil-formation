package org.tamyass.outilformation.service;

import org.springframework.web.multipart.MultipartFile;
import org.tamyass.outilformation.dto.SkillDTO;
import org.tamyass.outilformation.dto.cv.CVResponseDTO;
import org.tamyass.outilformation.dto.cv.CVSkillDTO;

import java.util.List;

public interface CVService {
    CVResponseDTO extractSkillFromCV(MultipartFile multipartFile);
    List<SkillDTO> saveSkills(Long userId,List<CVSkillDTO> skills);
}
