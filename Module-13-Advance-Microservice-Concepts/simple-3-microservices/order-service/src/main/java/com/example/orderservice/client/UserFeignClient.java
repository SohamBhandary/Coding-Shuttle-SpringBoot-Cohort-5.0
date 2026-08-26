package com.example.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(
        name = "user-service",
        url = "http://localhost:8081"
)
public interface UserFeignClient {

    @GetMapping("/users/{id}")
    Object getUser(@PathVariable Long id);
}
