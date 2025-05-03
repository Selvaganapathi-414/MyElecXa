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

    // Uncomment if needed
//    @GetMapping("/status/{status}")
//    public ResponseEntity<List<Order>> getOrdersByStatus(@PathVariable OrderStatus status) {
//        return ResponseEntity.ok(orderService.getOrdersByStatus(status));
//    }
//
//    @GetMapping("/product/{productId}")
//    public ResponseEntity<List<Order>> getOrdersByProduct(@PathVariable Long productId) {
//        return ResponseEntity.ok(orderService.getOrdersByProduct(productId));
//    }
//
//    @GetMapping("/date-range")
//    public ResponseEntity<List<Order>> getOrdersBetweenDates(@RequestParam String start,
//                                                             @RequestParam String end) {
//        return ResponseEntity.ok(orderService.getOrdersBetweenDates(
//                LocalDateTime.parse(start), LocalDateTime.parse(end)));
//    }
//
//    @PutMapping("/{orderId}/status")
//    public ResponseEntity<Order> updateOrderStatus(@PathVariable Long orderId,
//                                                   @RequestParam OrderStatus status) {
//        return ResponseEntity.ok(orderService.updateOrderStatus(orderId, status));
//    }
//
//    @DeleteMapping("/{orderId}")
//    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId) {
//        orderService.deleteOrder(orderId);
//        return ResponseEntity.noContent().build();
//    }
//
//    @GetMapping("/count/status")
//    public ResponseEntity<Long> countOrdersByStatus(@RequestParam OrderStatus status) {
//        return ResponseEntity.ok(orderService.countOrdersByStatus(status));
//    }
//
//    @GetMapping("/revenue")
//    public ResponseEntity<BigDecimal> getTotalRevenue() {
//        return ResponseEntity.ok(orderService.calculateTotalRevenue());
//    }
}
