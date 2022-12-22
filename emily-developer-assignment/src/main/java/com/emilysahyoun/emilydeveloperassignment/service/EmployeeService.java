package com.emilysahyoun.emilydeveloperassignment.service;

import com.emilysahyoun.emilydeveloperassignment.model.Employee;

import java.util.List;


public interface EmployeeService {
    public Employee createEmployee(Employee employee);
    public Employee updateEmployee(Employee employee) throws Exception;
    public List<Employee> getAllEmployees();
    public Employee getEmployeebyID(int id) throws Exception;
    public void  deleteEmployee(int id) throws Exception;
}
