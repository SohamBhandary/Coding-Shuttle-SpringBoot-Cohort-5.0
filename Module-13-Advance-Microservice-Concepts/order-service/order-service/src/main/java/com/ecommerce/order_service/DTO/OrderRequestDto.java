package com.ecommerce.order_service.DTO;

import com.ecommerce.order_service.Entitty.OrderStatus;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequestDto {

    private Long id;
    private OrderStatus orderStatus;
    private Double totalPrice;
    private List<OderRequestItemDto> items;
}