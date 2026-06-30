package com.ecommerce.inventory_service.DTOs;

import lombok.Data;

@Data
public class OrderRequestItemDto {
    private Long productId;
    private Integer quantity;
}

