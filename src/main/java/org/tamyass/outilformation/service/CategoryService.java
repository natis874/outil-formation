package org.tamyass.outilformation.service;

import org.tamyass.outilformation.dto.CategoryDTO;
import org.tamyass.outilformation.dto.SkillDTO;

import java.util.List;

public interface CategoryService {

    List<CategoryDTO> getAllCategories();

    CategoryDTO getCategoryById(Long id);

    CategoryDTO createCategory(CategoryDTO categoryDTO);
    CategoryDTO updateCategory(Long id,CategoryDTO categoryDTO);
    void deleteCategory(Long id);

}
