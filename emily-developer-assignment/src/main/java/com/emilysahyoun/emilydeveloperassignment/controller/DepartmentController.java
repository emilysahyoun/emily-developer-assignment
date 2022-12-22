package com.emilysahyoun.emilydeveloperassignment.controller;

import com.emilysahyoun.emilydeveloperassignment.model.Departments;
import com.emilysahyoun.emilydeveloperassignment.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/department")
    public ResponseEntity<List<Departments>> getAll(){
        return ResponseEntity.ok().body(departmentService.getAlldepartments());
    }

    @GetMapping("/department/{id}")
    public ResponseEntity<Departments> getDepartmentById(@PathVariable int id) throws Exception {
        return ResponseEntity.ok().body(departmentService.getDepartmentbyID(id));
    }

    @PostMapping("/department")
    public ResponseEntity<Departments> createDepartment(@Valid @RequestBody Departments departments){
        return ResponseEntity.ok().body(this.departmentService.createDepartment(departments));

    }
    @PutMapping("/department/{id}")
    public ResponseEntity<Departments> updateDepartment(@PathVariable int id, @RequestBody Departments departments) throws Exception {

        departments.setDepartmentID(id);
        return ResponseEntity.ok().body(this.departmentService.updateDepartment(departments));
    }

    @DeleteMapping("/department/{id}")
    public HttpStatus deleteDepartment(@PathVariable int id) throws Exception {
        this.departmentService.deleteDepartment(id);
        return HttpStatus.OK;
    }
}
