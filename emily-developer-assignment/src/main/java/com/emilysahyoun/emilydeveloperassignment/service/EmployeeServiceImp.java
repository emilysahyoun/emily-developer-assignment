package com.emilysahyoun.emilydeveloperassignment.service;

import com.emilysahyoun.emilydeveloperassignment.model.Employee;
import com.emilysahyoun.emilydeveloperassignment.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImp implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) throws Exception {
        Optional<Employee> employeeDb = this.employeeRepository.findById(employee.getEmployeeID());
        if(employeeDb.isPresent()) {
            Employee employeeUpdate = employeeDb.get();
            employeeUpdate.setEmployeeID(employee.getEmployeeID());
            employeeUpdate.setFirstName(employee.getFirstName());
            employeeUpdate.setLastName(employee.getLastName());
            employeeUpdate.setEmail(employee.getEmail());
            employeeUpdate.setPhoneNumber(employee.getPhoneNumber());
            employeeUpdate.setHireDate((employee.getHireDate()));
            employeeUpdate.setSalary(employee.getSalary());
            employeeUpdate.setManagerId(employee.getManagerId());
            employee.setDepartmentID(employee.getDepartmentID());
            employeeRepository.save(employeeUpdate);
            return employeeUpdate;
        }else {
            throw new Exception("Employee details not found " + employee.getEmployeeID());
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeebyID(int id) throws Exception {
        Optional<Employee> employeeDb = this.employeeRepository.findById(id);
        if(employeeDb.isPresent()) {
            return employeeDb.get();
        }else {
            throw new Exception("Employee details not found" + id);

        }
    }

    @Override
    public void deleteEmployee(int id) throws Exception {
        Optional<Employee> employeeDb = this.employeeRepository.findById(id);

        if(employeeDb.isPresent()) {
             this.employeeRepository.delete(employeeDb.get());
        }else {
            throw new Exception("Employee details not found " + id);

        }

    }
}
