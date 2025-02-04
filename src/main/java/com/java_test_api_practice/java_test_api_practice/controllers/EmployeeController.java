package com.java_test_api_practice.java_test_api_practice.controllers;

import com.java_test_api_practice.java_test_api_practice.models.dto.EventDateDto;
import com.java_test_api_practice.java_test_api_practice.models.entities.Employee;
import com.java_test_api_practice.java_test_api_practice.services.impl.EmployeeServiceImpl;
import com.java_test_api_practice.java_test_api_practice.utils.response.ApiResponse;
import com.java_test_api_practice.java_test_api_practice.utils.response.EventResponse;
import com.java_test_api_practice.java_test_api_practice.utils.response.ResponseUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Employee>>> getAllEmployees(HttpServletRequest request) {
        List<Employee> employeesList = employeeServiceImpl.getEmployees();
        return ResponseEntity.ok(ResponseUtil.success(
                        employeesList,
                        "List of employee",
                        request.getRequestURI()
                )
        );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Employee>> addEmployee(
            @RequestBody @Valid Employee employee,
            BindingResult bindingResult,
            HttpServletRequest request
    ) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(ResponseUtil.error(
                    bindingResult.getAllErrors().get(0).getDefaultMessage(),
                    "Error to create employee",
                    400,
                    request.getRequestURI()));
        }
        Employee employeeCreated = employeeServiceImpl.createEmployee(employee);
        return ResponseEntity.ok(ResponseUtil.success(
                employeeCreated,
                "Employee created successfully",
                request.getRequestURI()
        ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Employee>> getEmployee(
            @PathVariable Long id,
            HttpServletRequest request) {

        Employee employee = employeeServiceImpl.getEmployee(id);
        return ResponseEntity.ok(ResponseUtil.success(
                employee,
                "Employee found",
                request.getRequestURI()
        ));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Employee>> updateEmployee(
            @PathVariable Long id,
            @RequestBody @Valid Employee employee,
            BindingResult bindingResult,
            HttpServletRequest request
    ) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(ResponseUtil.error(
                    bindingResult.getAllErrors().get(0).getDefaultMessage(),
                    "Error to update employee",
                    400,
                    request.getRequestURI()
            ));
        }
        Employee updatedEmployee = employeeServiceImpl.updateEmployee(id, employee);
        return ResponseEntity.ok(ResponseUtil.success(
                updatedEmployee,
                "Employee updated successfully",
                request.getRequestURI()
        ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteEmployee(@PathVariable Long id, HttpServletRequest request) {
        String value = employeeServiceImpl.deleteEmployee(id);
        return ResponseEntity.ok(ResponseUtil.success(
                value,
                "Employee was deleted successfully",
                request.getRequestURI()
        ));
    }

    @PostMapping("/events")
    public ResponseEntity<ApiResponse<List<EventResponse>>> getEmployeeEvents(
            @RequestBody @Valid EventDateDto eventDate,
            BindingResult bindingResult,
            HttpServletRequest request
    ) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(ResponseUtil.error(
                    bindingResult.getAllErrors().get(0).getDefaultMessage(),
                    "Something wrong!!",
                    400,
                    request.getRequestURI()
            ));
        }
        List<EventResponse> eventResponse = employeeServiceImpl.getUpcomingEvents(eventDate);
        return ResponseEntity.ok(ResponseUtil.success(
                eventResponse,
                "Events in a date range",
                request.getRequestURI()
        ));
    }
}
