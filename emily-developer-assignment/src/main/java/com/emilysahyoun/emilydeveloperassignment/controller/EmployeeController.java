package com.emilysahyoun.emilydeveloperassignment.controller;


import com.emilysahyoun.emilydeveloperassignment.model.Employee;
import com.emilysahyoun.emilydeveloperassignment.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        return ResponseEntity.ok().body(employeeService.getAllEmployees());
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) throws Exception {
        return ResponseEntity.ok().body(employeeService.getEmployeebyID(id));
    }

    @PostMapping("/employee")
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee){
        return ResponseEntity.ok().body(this.employeeService.createEmployee(employee));

    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employee) throws Exception {

        employee.setEmployeeID(id);
        return ResponseEntity.ok().body(this.employeeService.updateEmployee(employee));
    }

    @DeleteMapping("/employee/{id}")
    public HttpStatus deleteEmployee(@PathVariable int id) throws Exception {
        this.employeeService.deleteEmployee(id);
        return HttpStatus.OK;
    }

}
