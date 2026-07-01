package com.ecommerce.order_service.Service;

import com.ecommerce.order_service.Clients.InventoryFeignClient;
import com.ecommerce.order_service.DTO.OrderRequestDto;
import com.ecommerce.order_service.Entitty.OrderItem;
import com.ecommerce.order_service.Entitty.OrderStatus;
import com.ecommerce.order_service.Entitty.Orders;
import com.ecommerce.order_service.OrderRepository.OrderRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final InventoryFeignClient inventoryFeignClient;


    public List<OrderRequestDto> getAllOrders() {
        log.info("Fetching all orders");
        List<Orders> orders = orderRepository.findAll();
        return orders.stream().map(order -> modelMapper.map(order, OrderRequestDto.class)).toList();
    }

    public OrderRequestDto getOrderById(Long id) {
        log.info("Fetching order with ID: {}", id);
        Orders order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        return modelMapper.map(order, OrderRequestDto.class);
    }



//    @Retry(name = "inventoryRetry",fallbackMethod ="createOrderFallback" )
    @CircuitBreaker(name = "inventoryCircuitBreaker",fallbackMethod = "createOrderFallback")
//    @RateLimiter(name = "inventoryRateLimiter",fallbackMethod = "createOrderFallback")
    public OrderRequestDto createOrder(OrderRequestDto orderRequestDto) {
        log.info("Calling the createOrder method");
        Double totalPrice = inventoryFeignClient.reduceStocks(orderRequestDto);

        Orders orders = modelMapper.map(orderRequestDto, Orders.class);
        for(OrderItem orderItem: orders.getItems()) {
            orderItem.setOrder(orders);
        }
        orders.setTotalPrice(totalPrice);
        orders.setOrderStatus(OrderStatus.CONFIRMED);

        Orders savedOrder = orderRepository.save(orders);

        return modelMapper.map(savedOrder, OrderRequestDto.class);
    }


    public OrderRequestDto createOrderFallback(OrderRequestDto orderRequestDto,Throwable throwable){
        log.error("Fallback occured due to :{} ",throwable.getMessage());

        return new OrderRequestDto();



    }


}
