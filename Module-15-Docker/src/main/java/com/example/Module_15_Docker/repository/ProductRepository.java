package com.example.Module_15_Docker.repository;

import com.codingshuttle.ecommerce.product_service.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
