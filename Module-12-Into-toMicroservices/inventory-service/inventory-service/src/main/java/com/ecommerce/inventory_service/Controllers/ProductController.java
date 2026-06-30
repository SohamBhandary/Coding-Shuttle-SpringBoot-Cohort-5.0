package com.ecommerce.inventory_service.Controllers;


import com.ecommerce.inventory_service.DTOs.ProductDto;
import com.ecommerce.inventory_service.Services.ProductServices;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductServices productService;
    private final DiscoveryClient discoveryClient;
    private final RestClient restClient;



    @GetMapping("/fetchOrders")
    public String fetchFromOrdersService(HttpServletRequest httpServletRequest) {

        log.info(httpServletRequest.getHeader("x-custom-header"));

        ServiceInstance orderService = discoveryClient
                .getInstances("order-service").getFirst();

        String res = restClient.get()
                .uri(orderService.getUri() + "/api/v1/orders/helloOrders")
                .retrieve()
                .body(String.class);

        return res;
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllInventory() {
        List<ProductDto> inventories = productService.getAllInventory();
        return ResponseEntity.ok(inventories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getInventoryById(@PathVariable Long id) {
        ProductDto inventory = productService.getProductById(id);
        return ResponseEntity.ok(inventory);
    }

//    @PutMapping("reduce-stocks")
//    public ResponseEntity<Double> reduceStocks(@RequestBody OrderRequestDto orderRequestDto) {
//        Double totalPrice = productService.reduceStocks(orderRequestDto);
//        return ResponseEntity.ok(totalPrice);
//    }


}
