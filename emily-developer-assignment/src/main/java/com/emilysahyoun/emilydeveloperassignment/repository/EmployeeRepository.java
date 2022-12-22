package com.emilysahyoun.emilydeveloperassignment.repository;

import com.emilysahyoun.emilydeveloperassignment.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}


