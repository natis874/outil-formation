package org.tamyass.outilformation.service;

import org.tamyass.outilformation.dto.SkillDTO;
import org.tamyass.outilformation.dto.UserDTO;

import java.util.List;

public interface SkillService {

    List<SkillDTO> getSkillsbyUserId(Long userId);

    SkillDTO UpdateEstimation(Long skillId, Integer level);

    List<SkillDTO> getSkillByCategoryId(Long categoryId);

}
