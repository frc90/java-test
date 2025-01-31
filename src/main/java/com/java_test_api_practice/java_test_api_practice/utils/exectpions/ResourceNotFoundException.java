package com.java_test_api_practice.java_test_api_practice.utils.exectpions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
