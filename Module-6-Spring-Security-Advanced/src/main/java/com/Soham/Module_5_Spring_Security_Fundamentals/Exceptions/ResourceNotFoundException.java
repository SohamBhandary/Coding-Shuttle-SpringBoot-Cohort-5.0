package com.Soham.Module_5_Spring_Security_Fundamentals.Exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
