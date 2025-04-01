package com.elecxa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elecxa.model.Payment;

import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    // Find a payment by its order ID
    Optional<Payment> findByOrderId(Long orderId);
    
    // Find a payment by its ID (inherited from JpaRepository)
    Optional<Payment> findById(Long paymentId);
}
