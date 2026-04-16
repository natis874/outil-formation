package org.tamyass.outilformation.service.impl;

import org.springframework.stereotype.Service;
import org.tamyass.outilformation.dto.CategoryDTO;
import org.tamyass.outilformation.entities.Category;
import org.tamyass.outilformation.exception.CategoryNotFoundException;
import org.tamyass.outilformation.mapper.CategoryMapper;
import org.tamyass.outilformation.repository.CategoryRepository;
import org.tamyass.outilformation.service.CategoryService;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }


    @Override
    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toDTO)
                .toList();
    }

    @Override
    public CategoryDTO getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .map(categoryMapper::toDTO)
                .orElseThrow(()-> new CategoryNotFoundException(id));
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = categoryMapper.toEntity(categoryDTO);
        Category savedCategory = categoryRepository.save(category);
        return categoryMapper.toDTO(savedCategory);
    }

    @Override
    public CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO) {
        Category existingCategoty =  categoryRepository.findById(id)
                .orElseThrow(()-> new CategoryNotFoundException(id));
        existingCategoty.setName(categoryDTO.getName().toString());
        return categoryMapper.toDTO(existingCategoty);
    }

    @Override
    public void deleteCategory(Long id) {
        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(()-> new CategoryNotFoundException(id));
        if (!existingCategory.getSkills().isEmpty()){
            throw new IllegalStateException("Impossible de supprimer une catégorie qui contient des skills");
        }
        categoryRepository.delete(existingCategory);
    }
}
