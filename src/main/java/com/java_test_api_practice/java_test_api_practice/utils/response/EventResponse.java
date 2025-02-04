package com.java_test_api_practice.java_test_api_practice.utils.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
public class EventResponse {
    private Long employeeId;
    private String employeeName;
    private List<String> event;

}
