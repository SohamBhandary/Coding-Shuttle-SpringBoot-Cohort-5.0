package com.ecommerce.order_service.DTO;

import lombok.Data;

@Data
public class OderRequestItemDto {
    private Long id;
    private Long productId;
    private Integer quantity;
}
