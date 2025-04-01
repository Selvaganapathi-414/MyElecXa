package com.elecxa.service;

import com.elecxa.Model.Cart;
import com.elecxa.Model.CartItem;

import com.elecxa.Model.Product;
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

    public Cart addToCart(Long productId, int quantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Cart cart = cartRepository.findByUserId(1L).orElse(new Cart()); // Assuming user ID 1 for now
        CartItem cartItem = new CartItem(null, cart, product, quantity, product.getPrice().multiply(new BigDecimal(quantity)));
        cart.getCartItems().add(cartItem);

        return cartRepository.save(cart);
    }

    public Cart updateCartItem(Long productId, int quantity) {
        Cart cart = cartRepository.findByUserId(1L)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        Optional<CartItem> cartItemOpt = cart.getCartItems().stream()
                .filter(item -> item.getProduct().getProductId().equals(productId))
                .findFirst();

        if (cartItemOpt.isPresent()) {
            CartItem cartItem = cartItemOpt.get();
            cartItem.setQuantity(quantity);
            cartItem.setPrice((cartItem.getProduct().getPrice().multiply(new BigDecimal(quantity))));
            return cartRepository.save(cart);
        } else {
            throw new RuntimeException("Item not found in cart");
        }
    }

    public void removeCartItem(Long productId) {
        Cart cart = cartRepository.findByUserId(1L)
                .orElseThrow(() -> new RuntimeException("Cart not found"));
        
        cart.getCartItems().removeIf(item -> item.getProduct().getProductId().equals(productId));
        cartRepository.save(cart);
    }

    public void emptyCart() {
        Cart cart = cartRepository.findByUserId(1L)
                .orElseThrow(() -> new RuntimeException("Cart not found"));
        
        cart.getCartItems().clear();
        cartRepository.save(cart);
    }

}
