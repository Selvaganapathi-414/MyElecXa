//package com.elecxa.service;
//
//import com.elecxa.model.Order;
//import com.elecxa.model.OrderStatus;
//import com.elecxa.repository.OrderRepository;
//import com.elecxa.repository.ProductRepository;
//import com.elecxa.repository.UserRepository;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.stereotype.Service;
//
//import java.math.BigDecimal;
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class OrderService {
//
//    @Autowired
//    private OrderRepository orderRepository;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private ProductRepository productRepository;
//
//    public Order placeOrder(Long userId, Long productId, BigDecimal totalAmount) {
//        Order order = new Order();
//        order.setUser(userRepository.findById(userId).orElse(null));
//        order.setProduct(productRepository.findById(productId).orElse(null));
//        order.setOrderedDate(LocalDateTime.now());
//        order.setExpectedDeliveryDate(LocalDateTime.now().plusDays(3)); // You can modify this logic
//        order.setTotalAmount(totalAmount);
//        order.setOrderStatus(OrderStatus.PLACED);
//        return orderRepository.save(order);
//    }
//
//    public Order getOrderById(Long orderId) {
//        return orderRepository.findById(orderId).orElse(null);
//    }
//
//    public List<Order> getAllOrders() {
//        return orderRepository.findAll();
//    }
//
//   
//
//    public List<Order> getOrdersByStatus(OrderStatus status) {
//        return orderRepository.findByStatus(status);
//    }
//
//    public List<Order> getOrdersByProduct(Long productId) {
//        return orderRepository.findByProductId(productId);
//    }
//
//    public List<Order> getOrdersBetweenDates(LocalDateTime start, LocalDateTime end) {
//        return orderRepository.findByOrderDateBetween(start, end);
//    }
//
//    public Order updateOrderStatus(Long orderId, OrderStatus status) {
//        Optional<Order> optionalOrder = orderRepository.findById(orderId);
//        if (optionalOrder.isPresent()) {
//            Order order = optionalOrder.get();
//            order.setOrderStatus(status);
//            return orderRepository.save(order);
//        }
//        return null;
//    }
//
//    public void deleteOrder(Long orderId) {
//        orderRepository.deleteById(orderId);
//    }
//
//   
//
//    public long countOrdersByStatus(OrderStatus status) {
//        return orderRepository.countByStatus(status);
//    }
//
//    public BigDecimal calculateTotalRevenue() {
//        return orderRepository.calculateTotalRevenue();
//    }
//
//  
//   
//}
