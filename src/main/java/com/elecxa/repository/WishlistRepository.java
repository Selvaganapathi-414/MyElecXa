package com.elecxa.repository;

import com.elecxa.Model.Wishlist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Long> {

    // Find a wishlist item by product ID
    Optional<Wishlist> findByProductId(Long productId);
    
    // Find all wishlist items (inherited from JpaRepository)
    List<Wishlist> findAll();
}
