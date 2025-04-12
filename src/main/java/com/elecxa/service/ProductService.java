package com.elecxa.service;

import com.elecxa.model.Product;
import com.elecxa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product create(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product getById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Product update(Long id, Product product) {
        Product existing = getById(id);
        existing.setName(product.getName());
        existing.setBrand(product.getBrand());
        existing.setDescription(product.getDescription());
        existing.setPrice(product.getPrice());
        existing.setStockQuantity(product.getStockQuantity());
        existing.setSubcategory(product.getSubcategory());
        existing.setDiscount(product.getDiscount());
        existing.setRating(product.getRating());
        existing.setWarranty(product.getWarranty());
        return productRepository.save(existing);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> getBySubCategory(Long subCategoryId) {
        return productRepository.findBySubcategory_SubcategoryId(subCategoryId);
    }

    public List<Product> searchByName(String keyword) {
        return productRepository.findByNameContainingIgnoreCase(keyword);
    }

    public List<Product> getLowStockProducts(int threshold) {
        return productRepository.findByStockQuantityLessThan(threshold);
    }

    public List<Product> getByBrand(String brand) {
        return productRepository.findByBrandIgnoreCase(brand);
    }

    public List<Product> bulkAdd(List<Product> products) {
        return productRepository.saveAll(products);
    }
}
