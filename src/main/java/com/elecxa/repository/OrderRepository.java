package com.elecxa.repository;

import com.elecxa.model.Order;
import com.elecxa.model.OrderStatus;
import com.elecxa.model.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    // Find orders by status
  //  List<Order> findByStatus(OrderStatus status);

    // Find orders by productId
    
   // List<Order> findByProductId(Product product);

    // Find orders between dates
    List<Order> findByOrderedDateBetween(LocalDateTime start, LocalDateTime end);

    // Count orders by status
    long countByOrderStatus(OrderStatus status);

    // Calculate total revenue (assuming totalAmount is stored as BigDecimal in Order)
    @Query("SELECT SUM(o.totalAmount) FROM Order o WHERE o.orderStatus = 'COMPLETED'")
    BigDecimal calculateTotalRevenue();

    // Get monthly revenue (for revenue chart data)
    @Query("SELECT FUNCTION('MONTH', o.orderedDate) AS month, SUM(o.totalAmount) FROM Order o " +
           "WHERE o.orderStatus = 'COMPLETED' GROUP BY FUNCTION('MONTH', o.orderedDate) ORDER BY month")
    List<Double> findMonthlyRevenue();

	List<Order> findByProduct(Product product);

	List<Order> findByOrderStatus(OrderStatus status);
}