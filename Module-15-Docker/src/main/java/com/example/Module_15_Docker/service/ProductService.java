package com.example.Module_15_Docker.service;


import com.example.Module_15_Docker.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(com.codingshuttle.ecommerce.product_service.entity.Product product) {
        log.info("Creating product: {}", product);
        productRepository.save(product);
    }

    public List<com.codingshuttle.ecommerce.product_service.entity.Product> getAllProducts() {
        log.info("Fetching all products");
        return productRepository.findAll();
    }
}
