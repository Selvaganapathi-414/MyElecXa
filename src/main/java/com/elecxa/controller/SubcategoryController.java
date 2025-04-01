package com.elecxa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elecxa.model.SubCategory;
import com.elecxa.service.SubcategoryService;

@RestController
@RequestMapping("/api/subcategories")
public class SubcategoryController {

    @Autowired
    private SubcategoryService subcategoryService;

    @PostMapping
    public ResponseEntity<SubCategory> addSubcategory(@RequestBody SubCategory subcategory) {
        return ResponseEntity.ok(subcategoryService.addSubcategory(subcategory));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubCategory> updateSubcategory(@PathVariable Long id, @RequestBody SubCategory subcategory) {
        return ResponseEntity.ok(subcategoryService.updateSubcategory(id, subcategory));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSubcategory(@PathVariable Long id) {
        subcategoryService.deleteSubcategory(id);
        return ResponseEntity.ok("Subcategory deleted successfully");
    }
}
