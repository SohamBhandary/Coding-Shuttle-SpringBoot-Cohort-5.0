package com.example.productservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    @GetMapping("/{id}")
    public ProductResponse getProduct(@PathVariable Long id) {
        log.info("Fetching product: {}", id);
        return new ProductResponse(id, "Laptop", 75000);
    }
}

record ProductResponse(Long id, String name, double price) {}
