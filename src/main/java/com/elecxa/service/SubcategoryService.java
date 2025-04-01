package com.elecxa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elecxa.model.SubCategory;
import com.elecxa.repository.SubcategoryRepository;

@Service
public class SubcategoryService {

    @Autowired
    private SubcategoryRepository subcategoryRepository;

    public SubCategory addSubcategory(SubCategory subcategory) {
        return subcategoryRepository.save(subcategory);
    }

    public SubCategory updateSubcategory(Long id, SubCategory subcategoryDetails) {
        SubCategory subcategory = subcategoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Subcategory not found"));
        subcategory.setName(subcategoryDetails.getName());
        return subcategoryRepository.save(subcategory);
    }

    public void deleteSubcategory(Long id) {
        subcategoryRepository.deleteById(id);
    }
}
