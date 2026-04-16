package org.tamyass.outilformation.service;

import org.tamyass.outilformation.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {

    List<CategoryDTO> getAllCategories();

    CategoryDTO getCategoryById(Long id);

    CategoryDTO updateCategory(Long id,CategoryDTO categoryDTO);

    CategoryDTO createCategory(CategoryDTO categoryDTO);
    void deleteCategory(Long id);
}
