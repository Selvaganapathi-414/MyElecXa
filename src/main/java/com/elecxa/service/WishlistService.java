package com.elecxa.service;

import com.elecxa.model.Product;
import com.elecxa.model.Wishlist;
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

  

    public List<Wishlist> getWishlist() {
        return wishlistRepository.findAll();
    }
}
