package org.tamyass.outilformation.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tamyass.outilformation.dto.CategoryDTO;
import org.tamyass.outilformation.service.CategoryService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryRestController {

    private final CategoryService categoryService;

    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    // GET /api/categories
    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategories(){
        List<CategoryDTO> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }
    // GET /api/categories/{id}
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id){
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }
    // POST /api/categories
    @PostMapping
    public ResponseEntity<CategoryDTO> createUser(@RequestBody CategoryDTO categoryDTO){
        CategoryDTO categoryCreated = categoryService.createCategory(categoryDTO);
        URI location =URI.create("/api/categories/"+ categoryCreated.getId());
        return ResponseEntity.created(location).body(categoryCreated);
    }
    // PUT /api/categories/{id}
    @PutMapping
    public ResponseEntity<CategoryDTO> updateCategory(
            @PathVariable Long id,
            @RequestBody CategoryDTO categoryDTO){
        CategoryDTO updatedCategory = categoryService.updateCategory(id, categoryDTO);
        return ResponseEntity.ok(updatedCategory);
    }
    // DELETE /api/categories/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(Long id){
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
