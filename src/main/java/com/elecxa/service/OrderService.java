package com.elecxa.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    // Simulating order data for example purposes
    // In a real-world scenario, you'd use a repository to interact with the database
    private static final Map<Long, String> orders = Map.of(
            1L, "Order 1 details",
            2L, "Order 2 details",
            3L, "Order 3 details"
    );

    public String placeOrder() {
        // Logic for placing an order
        // You would typically interact with the database or another service to place an order.
        return "Order placed successfully.";
    }

    public String getOrderDetails(Long orderId) {
        // Fetch order details using the orderId
        // In a real-world scenario, you'd fetch data from the database
        return orders.getOrDefault(orderId, "Order not found.");
    }

    public List<String> getOrderHistory() {
        // Return a list of orders, simulating order history for now
        return List.of("Order 1 - details", "Order 2 - details", "Order 3 - details");
    }

    public void cancelOrder(Long orderId) {
        // Logic for canceling an order
        // In a real-world scenario, you'd update the order's status in the database
        // Here we're just printing for demonstration purposes
        System.out.println("Order " + orderId + " has been canceled.");
    }
}
