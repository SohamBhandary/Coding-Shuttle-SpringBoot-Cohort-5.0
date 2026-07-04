package com.ecommerce.inventory_service.Clients;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="order-service",path = "/orders")
public interface OrdersFeignClient {

    @GetMapping("/core/helloOrders")
    public String helloOrders();


}
