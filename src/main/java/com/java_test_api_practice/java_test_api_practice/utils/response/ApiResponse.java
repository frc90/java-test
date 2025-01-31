package com.java_test_api_practice.java_test_api_practice.utils.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
    private boolean success;
    private T data;
    private String message;
    private List<String> errors;
    private int errorCode;
    private long timestamp;
    private String path;
}
