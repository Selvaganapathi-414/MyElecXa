package com.elecxa.Model;


import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Cart")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(nullable = false)
    private Integer productQuantity;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal discountedPrice;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProductAvailabilityStatus productAvailabilityStatus;
}

