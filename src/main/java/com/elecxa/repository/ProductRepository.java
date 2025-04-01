package com.elecxa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elecxa.model.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	 // Find a product by its ID
    Optional<Product> findById(Long productId);

    // Find all products by sub category ID
    List<Product> findBySubcategory_SubcategoryId(Long subcategoryId);

    // Find products by name (for search functionality)
    List<Product> findByNameContainingIgnoreCase(String name);

    // Find all products with a discount applied
    List<Product> findByDiscountGreaterThan(BigDecimal discount);

    // Find products within a price range
    List<Product> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
}