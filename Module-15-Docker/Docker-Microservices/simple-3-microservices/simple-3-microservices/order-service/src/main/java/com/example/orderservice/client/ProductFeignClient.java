package com.example.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(
        name = "product-service",
        url = "http://product-service:8082"
)
public interface ProductFeignClient {
    @GetMapping("/products/{id}")
    Object getProduct(@PathVariable Long id);
}
