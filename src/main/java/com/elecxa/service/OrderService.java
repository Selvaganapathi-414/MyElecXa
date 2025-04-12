package com.elecxa.service;

import com.elecxa.model.Order;
import com.elecxa.model.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface OrderService {

    Order placeOrder(Long userId, Long productId, BigDecimal totalAmount);

    Order getOrderById(Long orderId);

    List<Order> getAllOrders();

    List<Order> getOrdersByUser(Long userId);

    List<Order> getOrdersByStatus(OrderStatus status);

    List<Order> getOrdersByProduct(Long productId);

    List<Order> getOrdersBetweenDates(LocalDateTime start, LocalDateTime end);

    Order updateOrderStatus(Long orderId, OrderStatus status);

    void deleteOrder(Long orderId);

    List<Order> getRecentOrdersForUser(Long userId, int limit);

    long countOrdersByStatus(OrderStatus status);

    BigDecimal calculateTotalRevenue();

    List<Order> getUserOrdersByStatus(Long userId, OrderStatus status);

    boolean cancelOrder(Long orderId);
}
