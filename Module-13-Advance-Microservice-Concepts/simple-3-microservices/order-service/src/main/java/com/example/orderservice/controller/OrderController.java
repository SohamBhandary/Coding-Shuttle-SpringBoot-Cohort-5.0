package com.example.orderservice.controller;

import com.example.orderservice.client.ProductFeignClient;
import com.example.orderservice.client.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    private final UserFeignClient userClient;
    private final ProductFeignClient productClient;

    public OrderController(UserFeignClient userClient, ProductFeignClient productClient) {
        this.userClient = userClient;
        this.productClient = productClient;
    }

    @GetMapping("/{id}")
    public OrderResponse getOrder(@PathVariable Long id) {
        log.info("Fetching order: {}", id);

        var user = userClient.getUser(1L);
        var product = productClient.getProduct(1L);

        log.info("Order assembled successfully");

        return new OrderResponse(id, user, product);
    }
}

record OrderResponse(Long orderId, Object user, Object product) {}
