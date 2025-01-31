package com.java_test_api_practice.java_test_api_practice.controllers;

import com.java_test_api_practice.java_test_api_practice.models.entities.Employee;
import com.java_test_api_practice.java_test_api_practice.services.impl.EmployeeServiceImpl;
import com.java_test_api_practice.java_test_api_practice.utils.response.ApiResponse;
import com.java_test_api_practice.java_test_api_practice.utils.response.ResponseUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    @PutMapping
    public ResponseEntity<ApiResponse<Employee>> updateEmployee(
            @PathVariable Long id,
            @RequestBody Employee employee,
            HttpServletRequest request
    ) {
        Employee updatedEmployee = employeeServiceImpl.updateEmployee(id, employee);
        return ResponseEntity.ok(
                ResponseUtil.success(
                        updatedEmployee,
                        "Employee updated successfully",
                        request.getRequestURI()
                )
        );
    }
}
