package com.java_test_api_practice.java_test_api_practice.repositories;

import com.java_test_api_practice.java_test_api_practice.models.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
