package com.elecxa.service;

import com.elecxa.model.SubCategory;
import com.elecxa.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCategoryService {

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    public SubCategory create(SubCategory subCategory) {
        return subCategoryRepository.save(subCategory);
    }

    public List<SubCategory> getAll() {
        return subCategoryRepository.findAll();
    }

    public SubCategory getById(Long id) {
        return subCategoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Subcategory not found"));
    }

    public SubCategory update(Long id, SubCategory subCategory) {
        SubCategory existing = getById(id);
        existing.setName(subCategory.getName());
        existing.setCategory(subCategory.getCategory());
        return subCategoryRepository.save(existing);
    }

    public void delete(Long id) {
        subCategoryRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return subCategoryRepository.existsById(id);
    }

    public long count() {
        return subCategoryRepository.count();
    }

    public List<SubCategory> searchByName(String keyword) {
        return subCategoryRepository.findByNameContainingIgnoreCase(keyword);
    }

    public List<SubCategory> getByCategoryId(Long categoryId) {
        return subCategoryRepository.findByCategory_CategoryId(categoryId);
    }

    public List<SubCategory> bulkAdd(List<SubCategory> subCategories) {
        return subCategoryRepository.saveAll(subCategories);
    }
}
