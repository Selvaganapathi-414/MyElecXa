package com.elecxa.controller;

import com.elecxa.model.*;
import com.elecxa.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin("*")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/all")
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @GetMapping("/{id}")
    public Optional<Payment> getPaymentById(@PathVariable Long id) {
        return paymentService.getPaymentById(id);
    }

    @GetMapping("/ref/{refId}")
    public Optional<Payment> getPaymentByRefId(@PathVariable String refId) {
        return paymentService.getPaymentByRefId(refId);
    }

    @GetMapping("/user/{userId}")
    public List<Payment> getPaymentsByUser(@PathVariable("userId") User user) {
        return paymentService.getPaymentsByUser(user);
    }

    @GetMapping("/order/{orderId}")
    public List<Payment> getPaymentsByOrder(@PathVariable("orderId") Order order) {
        return paymentService.getPaymentsByOrder(order);
    }

    @GetMapping("/product/{productId}")
    public List<Payment> getPaymentsByProduct(@PathVariable("productId") Product product) {
        return paymentService.getPaymentsByProduct(product);
    }

    @PostMapping
    public Payment createPayment(@RequestBody Payment payment) {
        return paymentService.createPayment(payment);
    }

    @PutMapping
    public Payment updatePayment(@RequestBody Payment payment) {
        return paymentService.updatePayment(payment);
    }

    @DeleteMapping("/{id}")
    public void deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
    }
}
