package com.elecxa.repository;

import com.elecxa.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByNameContainingIgnoreCase(String keyword);
    List<Product> findBySubcategory_SubcategoryId(Long subcategoryId);
    List<Product> findByStockQuantityLessThan(Integer threshold);
    List<Product> findByBrandIgnoreCase(String brand);
	List<Product> findBySubcategory_Category_CategoryId(Long categoryId);
}
