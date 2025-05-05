package com.elecxa.service;

import com.elecxa.model.Order;
import com.elecxa.model.OrderStatus;
import com.elecxa.model.Product;
import com.elecxa.repository.OrderRepository;
import com.elecxa.repository.ProductRepository;
import com.elecxa.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    public Order placeOrder(Long userId, Long productId, BigDecimal totalAmount) {
        Order order = new Order();
        order.setUser(userRepository.findById(userId).orElse(null));
        order.setProduct(productRepository.findById(productId).orElse(null));
        order.setOrderedDate(LocalDateTime.now());
        order.setExpectedDeliveryDate(LocalDateTime.now().plusDays(3));
        order.setTotalAmount(totalAmount);
        order.setOrderStatus(OrderStatus.PLACED);
        return orderRepository.save(order);
    }
    

    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public List<Order> getOrdersByStatus(OrderStatus status) {
        return orderRepository.findByOrderStatus(status);
    }

    public List<Order> getOrdersByProduct(Long productId) {
    	Product product = productRepository.findById(productId).get();
        return orderRepository.findByProduct(product);
    }

    public List<Order> getOrdersBetweenDates(LocalDateTime start, LocalDateTime end) {
        return orderRepository.findByOrderedDateBetween(start, end);
    }

    public Order updateOrderStatus(Long orderId, OrderStatus status) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            order.setOrderStatus(status);
            return orderRepository.save(order);
        }
        
        return null;
    }
   
    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    public long countOrdersByStatus(OrderStatus status) {
        return orderRepository.countByOrderStatus(status);
    }

    public BigDecimal calculateTotalRevenue() {
        return orderRepository.calculateTotalRevenue();
    }

    // ✅ Add total order count
    public long getTotalOrderCount() {
        return orderRepository.count();
    }

    // ✅ Add recent orders (latest 5 orders)
    public List<Order> getRecentOrders() {
        return orderRepository.findAll(PageRequest.of(0, 5)).getContent();
    }

    // ✅ Add revenue chart data (dummy month-wise revenue, you can change this logic)
    public List<Double> getRevenueChartData() {
        return orderRepository.findMonthlyRevenue(); // Ensure this is defined in repository
    }
    

}
