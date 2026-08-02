package com.Soham.Module_20_Webflux.error;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String resourceType, Long id) {
        super("Resource: "+resourceType+" not found with id: "+id);
    }
}
