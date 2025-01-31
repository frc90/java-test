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
        List<Employee> employees = employeeRepository.findAll();
        if (!employees.isEmpty()) {
            return employees;
        }else {
            throw new ResourceNotFoundException("No employee found");
        }
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(Long id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent()) {
            return employeeOptional.get();
        }else{
            throw new ResourceNotFoundException("Employee not found");
        }

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
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent()) {
            employeeRepository.delete(employeeOptional.get());
            return "Employee " + employeeOptional.get().getUsername() + " deleted.";
        }else{
            throw new ResourceNotFoundException("Employee not found with id " + id);
        }
    }
}
