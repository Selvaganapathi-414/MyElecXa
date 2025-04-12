package com.elecxa.controller;

import com.elecxa.model.Order;
import com.elecxa.model.OrderStatus;
import com.elecxa.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
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

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Order>> getOrdersByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(orderService.getOrdersByUser(userId));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Order>> getOrdersByStatus(@PathVariable OrderStatus status) {
        return ResponseEntity.ok(orderService.getOrdersByStatus(status));
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Order>> getOrdersByProduct(@PathVariable Long productId) {
        return ResponseEntity.ok(orderService.getOrdersByProduct(productId));
    }

    @GetMapping("/date-range")
    public ResponseEntity<List<Order>> getOrdersBetweenDates(@RequestParam String start,
                                                             @RequestParam String end) {
        return ResponseEntity.ok(orderService.getOrdersBetweenDates(
                LocalDateTime.parse(start), LocalDateTime.parse(end)));
    }

    @PutMapping("/{orderId}/status")
    public ResponseEntity<Order> updateOrderStatus(@PathVariable Long orderId,
                                                   @RequestParam OrderStatus status) {
        return ResponseEntity.ok(orderService.updateOrderStatus(orderId, status));
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/recent/{userId}")
    public ResponseEntity<List<Order>> getRecentOrders(@PathVariable Long userId,
                                                       @RequestParam(defaultValue = "5") int limit) {
        return ResponseEntity.ok(orderService.getRecentOrdersForUser(userId, limit));
    }

    @GetMapping("/count/status")
    public ResponseEntity<Long> countOrdersByStatus(@RequestParam OrderStatus status) {
        return ResponseEntity.ok(orderService.countOrdersByStatus(status));
    }

    @GetMapping("/revenue")
    public ResponseEntity<BigDecimal> getTotalRevenue() {
        return ResponseEntity.ok(orderService.calculateTotalRevenue());
    }

    @GetMapping("/user/{userId}/status")
    public ResponseEntity<List<Order>> getUserOrdersByStatus(@PathVariable Long userId,
                                                             @RequestParam OrderStatus status) {
        return ResponseEntity.ok(orderService.getUserOrdersByStatus(userId, status));
    }

    @PutMapping("/{orderId}/cancel")
    public ResponseEntity<Boolean> cancelOrder(@PathVariable Long orderId) {
        return ResponseEntity.ok(orderService.cancelOrder(orderId));
    }
}
