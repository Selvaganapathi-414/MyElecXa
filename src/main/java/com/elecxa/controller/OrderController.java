package com.elecxa.controller;

import com.elecxa.model.Order;
import com.elecxa.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "http://localhost:8080")

public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/place")
    public ResponseEntity<Order> placeOrder(@RequestParam Long userId,
                                            @RequestParam Long productId,
                                            @RequestParam BigDecimal totalAmount) {
        return ResponseEntity.ok(orderService.placeOrder(userId, productId, totalAmount));
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long orderId) {
        return ResponseEntity.ok(orderService.getOrderById(orderId));
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }


    @GetMapping("/total-orders")
    public ResponseEntity<Long> getTotalOrderCount() {
        return ResponseEntity.ok(orderService.getTotalOrderCount());
    }

    @GetMapping("/recent")
    public ResponseEntity<List<Order>> getRecentOrders() {
        return ResponseEntity.ok(orderService.getRecentOrders());
    }

    @GetMapping("/revenue-data")
    public ResponseEntity<List<Double>> getRevenueChartData() {
        return ResponseEntity.ok(orderService.getRevenueChartData());
    }
}
