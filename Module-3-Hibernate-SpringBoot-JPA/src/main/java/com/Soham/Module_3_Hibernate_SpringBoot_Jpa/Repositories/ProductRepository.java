package com.Soham.Module_3_Hibernate_SpringBoot_Jpa.Repositories;

import com.Soham.Module_3_Hibernate_SpringBoot_Jpa.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    Product findByTitle(String title);

    List<Product> findByCreatedAtAfter(LocalDateTime after);
    List<Product> findByQuantityAndPrice(int quantity,int price);
    List<Product> findByTitleLike(String title);


    @Query("Select p from Product p where p.title=:title and p.price=price")
    Optional<Product> findByTitleAndPrice(String title, String price);
}
