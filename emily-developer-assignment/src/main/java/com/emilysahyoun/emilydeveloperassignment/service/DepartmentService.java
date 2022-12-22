package com.emilysahyoun.emilydeveloperassignment.service;

import com.emilysahyoun.emilydeveloperassignment.model.Departments;
import com.emilysahyoun.emilydeveloperassignment.model.Employee;

import java.util.List;

public interface DepartmentService {
    public Departments createDepartment(Departments departments);
    public Departments updateDepartment(Departments departments) throws Exception;
    public List<Departments> getAlldepartments();
    public Departments getDepartmentbyID(int id) throws Exception;
    public void  deleteDepartment(int id) throws Exception;
}
