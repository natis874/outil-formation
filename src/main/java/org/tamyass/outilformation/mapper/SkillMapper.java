package org.tamyass.outilformation.mapper;

import org.mapstruct.Mapper;
import org.tamyass.outilformation.dto.SkillDTO;
import org.tamyass.outilformation.entities.Skill;


@Mapper(componentModel = "spring")
public interface SkillMapper {
    SkillDTO toDTO(Skill skill);
    Skill toEntity(SkillDTO skillDTO);

}
