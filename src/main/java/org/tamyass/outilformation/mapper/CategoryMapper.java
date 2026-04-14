package org.tamyass.outilformation.mapper;

import org.mapstruct.Mapper;
import org.tamyass.outilformation.dto.CategoryDTO;
import org.tamyass.outilformation.dto.SkillDTO;
import org.tamyass.outilformation.entities.Category;
import org.tamyass.outilformation.entities.Skill;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDTO toDTO(Category category);
    Category toEntity(CategoryDTO categoryDTO);
}
