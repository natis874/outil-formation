package org.tamyass.outilformation.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tamyass.outilformation.dto.CategoryDTO;
import org.tamyass.outilformation.dto.UserDTO;
import org.tamyass.outilformation.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryRestController {

    private CategoryService categoryService;

    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategories(){
        List<CategoryDTO> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id){
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }
      

}
