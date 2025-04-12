package com.elecxa.service;

import com.elecxa.model.ProductAttribute;
import com.elecxa.repository.ProductAttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductAttributeService {

    @Autowired
    private ProductAttributeRepository repository;

    public ProductAttribute create(ProductAttribute attribute) {
        return repository.save(attribute);
    }

    public List<ProductAttribute> getAll() {
        return repository.findAll();
    }

    public ProductAttribute getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Attribute not found"));
    }

    public ProductAttribute update(Long id, ProductAttribute attribute) {
        ProductAttribute existing = getById(id);
        existing.setAttributeName(attribute.getAttributeName());
        existing.setAttributeValue(attribute.getAttributeValue());
        existing.setProduct(attribute.getProduct());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<ProductAttribute> getByProductId(Long productId) {
        return repository.findByProduct_ProductId(productId);
    }

    public List<ProductAttribute> searchByName(String name) {
        return repository.findByAttributeNameContainingIgnoreCase(name);
    }

    public List<ProductAttribute> searchByValue(String value) {
        return repository.findByAttributeValueContainingIgnoreCase(value);
    }

    public List<ProductAttribute> bulkAdd(List<ProductAttribute> attributes) {
        return repository.saveAll(attributes);
    }

    public Long count() {
        return repository.count();
    }
}
