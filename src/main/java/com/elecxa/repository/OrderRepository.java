
package com.elecxa.repository;

import com.elecxa.model.Order;

import com.elecxa.model.OrderStatus;
import com.elecxa.model.Product;
import com.elecxa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByUser(User user);

    List<Order> findByOrderStatus(OrderStatus status);

    List<Order> findByProduct(Product product);

    List<Order> findByOrderedDateBetween(LocalDateTime start, LocalDateTime end);

    long countByOrderStatus(OrderStatus status);

    List<Order> findTop5ByUserOrderByOrderedDateDesc(User user);

    List<Order> findByUserAndOrderStatus(User user, OrderStatus status);
    
}
//package com.elecxa.repository;
//
//import com.elecxa.model.Order;
//import com.elecxa.model.OrderStatus;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import java.math.BigDecimal;
//import java.time.LocalDateTime;
//import java.util.List;
//
//public interface OrderRepository extends JpaRepository<Order, Long> {
//
//
//    List<Order> findByStatus(OrderStatus status);
//
//    List<Order> findByProductId(Long productId);
//
//    List<Order> findByOrderDateBetween(LocalDateTime start, LocalDateTime end);
//
//
//    long countByStatus(OrderStatus status);
//
//    @Query("SELECT SUM(o.totalAmount) FROM Order o")
//    BigDecimal calculateTotalRevenue();
//
//}

