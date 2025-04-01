package com.elecxa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elecxa.model.SubCategory;

@Repository
public interface SubcategoryRepository extends JpaRepository<SubCategory, Long> {
}
