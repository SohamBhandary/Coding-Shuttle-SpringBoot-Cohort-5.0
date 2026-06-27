package com.Soham.Module_10_Aspect_Oriented_Programming.Services;

public interface ShipmentService {
    String orderPackage(Long orderId);

    String trackPackage(Long orderId);
}
