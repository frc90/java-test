package com.java_test_api_practice.java_test_api_practice.services.impl;

import com.java_test_api_practice.java_test_api_practice.models.entities.Employee;
import com.java_test_api_practice.java_test_api_practice.repositories.EmployeeRepository;
import com.java_test_api_practice.java_test_api_practice.services.interfaces.EmployeeService;
import com.java_test_api_practice.java_test_api_practice.utils.exectpions.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployees() {
        return List.of();
    }

    @Override
    public String createEmployee(Employee employee) {
        return "";
    }

    @Override
    public Employee getEmployee(Long id) {
        return null;
    }

    @Override
    @Transactional
    public Employee updateEmployee(Long id, Employee employee) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);

        if (employeeOptional.isPresent()) {
            Employee existingEmployee = employeeOptional.get();
            existingEmployee.setUsername(employee.getUsername());
            existingEmployee.setLastname(employee.getLastname());
            existingEmployee.setEmail(employee.getEmail());
            existingEmployee.setBirthday(employee.getBirthday());
            existingEmployee.setStartDay(employee.getStartDay());
            existingEmployee.setActive(employee.getActive());
            return employeeRepository.save(existingEmployee);
        }else {
            throw new ResourceNotFoundException("Employee not found with id " + id);
        }
    }

    @Override
    public String deleteEmployee(Long id) {
        return "";
    }
}
