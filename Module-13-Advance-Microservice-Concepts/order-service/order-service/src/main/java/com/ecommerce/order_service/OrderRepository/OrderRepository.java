package com.ecommerce.order_service.OrderRepository;

import com.ecommerce.order_service.Entitty.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders,Long> {
}
