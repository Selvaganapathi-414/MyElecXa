package com.elecxa.repository;

import com.elecxa.Model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    // Find a cart by the user ID
    Optional<Cart> findByUserId(Long userId);
}
