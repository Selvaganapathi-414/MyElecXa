package com.elecxa.service;

import com.elecxa.Model.Product;
import com.elecxa.Model.Wishlist;
import com.elecxa.repository.ProductRepository;
import com.elecxa.repository.WishlistRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WishlistService {

    private final WishlistRepository wishlistRepository;
    private final ProductRepository productRepository;

    public WishlistService(WishlistRepository wishlistRepository, ProductRepository productRepository) {
        this.wishlistRepository = wishlistRepository;
        this.productRepository = productRepository;
    }

    public Wishlist addToWishlist(Long productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isEmpty()) {
            throw new RuntimeException("Product not found");
        }

        Product product = productOptional.get();
        Wishlist wishlist = new Wishlist();
        wishlist.setProduct(product);

        return wishlistRepository.save(wishlist);
    }

    public void removeFromWishlist(Long productId) {
        Optional<Wishlist> wishlistItem = wishlistRepository.findByProductId(productId);
        wishlistItem.ifPresent(wishlistRepository::delete);
    }

    public List<Wishlist> getWishlist() {
        return wishlistRepository.findAll();
    }
}
