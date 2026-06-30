package com.ecommerce.inventory_service.Repositoires;

import com.ecommerce.inventory_service.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
