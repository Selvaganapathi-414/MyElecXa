package com.elecxa.controller;

import com.elecxa.model.Payment;
import com.elecxa.model.PaymentMode;
import com.elecxa.model.PaymentStatus;
import com.elecxa.model.User;
import com.elecxa.service.PaymentService;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import jakarta.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/payments")
public class PaymentController {

    @Value("${razorpay.key_id}")
    private String razorpayKeyId;

    @Value("${razorpay.key_secret}")
    private String razorpaySecret;

    @Autowired
    public PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/initiate")
    public ResponseEntity<Map<String, Object>> initiatePayment(@RequestParam("amount") double amount) {
        Map<String, Object> response = paymentService.initiatePayment(amount);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/save")
    public String savePayment(
            @RequestParam String paymentId,
            @RequestParam String razorpayOrderId,
            @RequestParam String signature,
            @RequestParam BigDecimal amount,
            HttpSession session
    ) {
        Long userId = (Long) session.getAttribute("userId");

        Payment payment = new Payment();
        payment.setPaymentRefId(paymentId);
        payment.setAmount(amount);
        payment.setPaymentStatus(PaymentStatus.SUCCESS);
        payment.setMode(PaymentMode.UPI);
        User user = new User();
        user.setUserId(userId);
        payment.setUser(user); 

        paymentService.savePayment(payment);
        return "Payment successful";
    }
}
