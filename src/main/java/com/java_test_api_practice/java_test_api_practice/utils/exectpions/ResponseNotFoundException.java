package com.java_test_api_practice.java_test_api_practice.utils.exectpions;

public class ResponseNotFoundException extends RuntimeException {
    public ResponseNotFoundException(String message) {
        super(message);
    }
}
