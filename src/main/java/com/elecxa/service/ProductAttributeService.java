package com.elecxa.service;

import com.elecxa.model.ProductAttribute;
import com.elecxa.repository.ProductAttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductAttributeService {

    @Autowired
    private ProductAttributeRepository productAttributeRepository;

    // Method to get all product attributes
    public List<ProductAttribute> getAllProductAttributes() {
        return productAttributeRepository.findAll();
    }

    // Method to get a product attribute by its ID
    public Optional<ProductAttribute> getProductAttributeById(Long id) {
        return productAttributeRepository.findById(id);
    }

    // Method to create a new product attribute
    public ProductAttribute createProductAttribute(ProductAttribute productAttribute) {
        return productAttributeRepository.save(productAttribute);
    }

    // Method to update a product attribute
    public ProductAttribute updateProductAttribute(Long id, ProductAttribute productAttributeDetails) {
        Optional<ProductAttribute> productAttributeOptional = productAttributeRepository.findById(id);
        if (productAttributeOptional.isPresent()) {
            ProductAttribute productAttribute = productAttributeOptional.get();
            productAttribute.setAttributeName(productAttributeDetails.getAttributeName());
            productAttribute.setAttributeValue(productAttributeDetails.getAttributeValue());
            productAttribute.setProduct(productAttributeDetails.getProduct());
            return productAttributeRepository.save(productAttribute);
        }
        return null; // Or throw an exception
    }

    // Method to delete a product attribute
    public void deleteProductAttribute(Long id) {
        productAttributeRepository.deleteById(id);
    }
}
