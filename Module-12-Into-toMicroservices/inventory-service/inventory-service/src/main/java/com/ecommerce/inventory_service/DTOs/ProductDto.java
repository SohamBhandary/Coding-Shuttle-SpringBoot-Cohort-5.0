package com.ecommerce.inventory_service.DTOs;


import lombok.Data;

@Data
public class ProductDto {

    private Long id;

    private String name;

    private Double price;

    private Integer stock;
}
