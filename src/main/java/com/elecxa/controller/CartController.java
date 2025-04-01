package com.elecxa.controller;

import com.elecxa.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/add/{productId}")
    public ResponseEntity<?> addToCart(@PathVariable Long productId, @RequestParam int quantity) {
        return ResponseEntity.ok(cartService.addToCart(productId, quantity));
    }

    @PutMapping("/update/{productId}")
    public ResponseEntity<?> updateCartItem(@PathVariable Long productId, @RequestParam int quantity) {
        return ResponseEntity.ok(cartService.updateCartItem(productId, quantity));
    }

    @DeleteMapping("/remove/{productId}")
    public ResponseEntity<?> removeCartItem(@PathVariable Long productId) {
        cartService.removeCartItem(productId);
        return ResponseEntity.ok(Map.of("message", "Item removed from cart."));
    }


    @PutMapping("/empty")
    public ResponseEntity<?> emptyCart() {
        cartService.emptyCart();
        return ResponseEntity.ok(Map.of("message", "Cart emptied."));
    }
}
