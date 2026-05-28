package com.Soham.Module_3_Hibernate_SpringBoot_Jpa.Controllers;

import com.Soham.Module_3_Hibernate_SpringBoot_Jpa.Entities.Product;
import com.Soham.Module_3_Hibernate_SpringBoot_Jpa.Repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final int PAGE_SIZE =5;

    private final ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts(@RequestParam(defaultValue = "id") String sortBy, @RequestParam(defaultValue = "1") Integer pageNumber){
//      return   productRepository.findBy(Sort.by(sortBy));
//        return   productRepository.findBy(Sort.by(Sort.Direction.DESC,sortBy,"price"));
//        Sort.Order.desc(sortBy),Sort.Order.asc("price")

        Pageable pageable= PageRequest.of(pageNumber,PAGE_SIZE);

        return productRepository.findAll(pageable).getContent();
    }
}
