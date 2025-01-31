package com.java_test_api_practice.java_test_api_practice.services.interfaces;

import com.java_test_api_practice.java_test_api_practice.models.entities.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();
    Employee createEmployee(Employee employee);
    Employee getEmployee(Long id);
    Employee updateEmployee(Long id, Employee employee);
    String deleteEmployee(Long id);
}
