package com.elecxa.controller;

import com.elecxa.model.Category;
import com.elecxa.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories") // ✅ Now it's just "api"
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // 1. Create a new category
    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        return ResponseEntity.ok(categoryService.create(category));
    }

    // 2. Get all categories
    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAll());
    }

    // 3. Get category by ID
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.getById(id));
    }

    // 4. Update category by ID
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category) {
        return ResponseEntity.ok(categoryService.update(id, category));
    }

    // 5. Delete category by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // 6. Check if category exists
    @GetMapping("/{id}/exists")
    public ResponseEntity<Boolean> exists(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.existsById(id));
    }

    // 7. Get total number of categories
    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(categoryService.count());
    }

    // 8. Search category by name
    @GetMapping("/search")
    public ResponseEntity<List<Category>> search(@RequestParam("keyword") String keyword) {
        return ResponseEntity.ok(categoryService.searchByName(keyword));
    }

    // 9. Add multiple categories
    @PostMapping("/bulk")
    public ResponseEntity<List<Category>> bulkAdd(@RequestBody List<Category> categories) {
        return ResponseEntity.ok(categories.stream().map(categoryService::create).toList());
    }

    // 10. Get first N categories
    @GetMapping("/limit/{count}")
    public ResponseEntity<List<Category>> getFirstN(@PathVariable int count) {
        List<Category> all = categoryService.getAll();
        return ResponseEntity.ok(all.stream().limit(count).toList());
    }
}
