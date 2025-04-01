package com.elecxa.controller;

import com.elecxa.model.ProductAttribute;
import com.elecxa.service.ProductAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product-attributes")
public class ProductAttributeController {

    @Autowired
    private ProductAttributeService productAttributeService;

    @GetMapping
    public List<ProductAttribute> getAllProductAttributes() {
        return productAttributeService.getAllProductAttributes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductAttribute> getProductAttributeById(@PathVariable Long id) {
        Optional<ProductAttribute> productAttribute = productAttributeService.getProductAttributeById(id);
        return productAttribute.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProductAttribute> createProductAttribute(@RequestBody ProductAttribute productAttribute) {
        ProductAttribute createdProductAttribute = productAttributeService.createProductAttribute(productAttribute);
        return new ResponseEntity<>(createdProductAttribute, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductAttribute> updateProductAttribute(@PathVariable Long id, @RequestBody ProductAttribute productAttribute) {
        ProductAttribute updatedProductAttribute = productAttributeService.updateProductAttribute(id, productAttribute);
        return updatedProductAttribute != null ? ResponseEntity.ok(updatedProductAttribute) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductAttribute(@PathVariable Long id) {
        productAttributeService.deleteProductAttribute(id);
        return ResponseEntity.noContent().build();
    }
}
