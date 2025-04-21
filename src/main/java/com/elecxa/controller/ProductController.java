package com.elecxa.controller;

import com.elecxa.model.Product;
import com.elecxa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // 1. Create product
    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        return ResponseEntity.ok(productService.create(product));
    }

    // 2. Get all products
    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(productService.getAll());
    }

    // 3. Get product by ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getById(id));
    }

    // 4. Update product
    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product product) {
        return ResponseEntity.ok(productService.update(id, product));
    }

    // 5. Delete product
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // 6. Get products by subcategory ID
    @GetMapping("/subcategory/{subCategoryId}")
    public ResponseEntity<List<Product>> getBySubCategory(@PathVariable Long subCategoryId) {
        return ResponseEntity.ok(productService.getBySubCategory(subCategoryId));
    }

    // 7. Search product by name
    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchByName(@RequestParam String keyword) {
        return ResponseEntity.ok(productService.searchByName(keyword));
    }

    // 8. Get low stock products
    @GetMapping("/low-stock")
    public ResponseEntity<List<Product>> getLowStock(@RequestParam(defaultValue = "5") int threshold) {
        return ResponseEntity.ok(productService.getLowStockProducts(threshold));
    }

    // 9. Get products by brand
    @GetMapping("/brand/{brand}")
    public ResponseEntity<List<Product>> getByBrand(@PathVariable String brand) {
        return ResponseEntity.ok(productService.getByBrand(brand));
    }

    // 10. Bulk add products
    @PostMapping("/bulk")
    public ResponseEntity<List<Product>> bulkAdd(@RequestBody List<Product> products) {
        return ResponseEntity.ok(productService.bulkAdd(products));
    }
    
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable Long categoryId) {
        List<Product> products = productService.getProductsByCategory(categoryId);
        return ResponseEntity.ok(products);
    }
}
