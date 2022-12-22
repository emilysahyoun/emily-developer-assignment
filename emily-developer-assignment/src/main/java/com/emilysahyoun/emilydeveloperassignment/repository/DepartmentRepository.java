package com.emilysahyoun.emilydeveloperassignment.repository;

import com.emilysahyoun.emilydeveloperassignment.model.Departments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Departments, Integer> {
}
