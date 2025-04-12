package com.elecxa.controller;

import com.elecxa.service.WishlistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/wishlist")
public class WishlistController {

    private final WishlistService wishlistService;

    public WishlistController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    @PostMapping("/add/{productId}")
    public ResponseEntity<?> addToWishlist(@PathVariable Long productId) {
        return ResponseEntity.ok(wishlistService.addToWishlist(productId));
    }

   

    @GetMapping
    public ResponseEntity<?> getWishlist() {
        return ResponseEntity.ok(wishlistService.getWishlist());
    }
}
