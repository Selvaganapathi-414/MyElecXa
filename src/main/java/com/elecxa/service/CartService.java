package com.elecxa.service;

import com.elecxa.model.Cart;
import com.elecxa.model.CartItem;
import com.elecxa.model.Product;
import com.elecxa.repository.CartRepository;
import com.elecxa.repository.ProductRepository;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public CartService(CartRepository cartRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

}
