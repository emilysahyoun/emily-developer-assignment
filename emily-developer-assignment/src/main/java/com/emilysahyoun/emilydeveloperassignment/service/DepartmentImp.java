package com.emilysahyoun.emilydeveloperassignment.service;

import com.emilysahyoun.emilydeveloperassignment.model.Departments;
import com.emilysahyoun.emilydeveloperassignment.repository.DepartmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DepartmentImp implements DepartmentService{
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Departments createDepartment(Departments departments) {
        return departmentRepository.save(departments);    }

    @Override
    public Departments updateDepartment(Departments departments) throws Exception {
        Optional<Departments> departmentsDb = this.departmentRepository.findById(departments.getDepartmentID());
        if(departmentsDb.isPresent()) {
            Departments departmentUpdate = departmentsDb.get();
            departmentUpdate.setDepartmentID(departments.getDepartmentID());
            departmentUpdate.setDepartmentName(departments.getDepartmentName());
            departmentUpdate.setManagerID(departments.getManagerID());
            departmentRepository.save(departmentUpdate);
            return departmentUpdate;
        }else {
            throw new Exception("Department details not found " + departments.getDepartmentID());
        }
    }

    @Override
    public List<Departments> getAlldepartments() {
        return this.departmentRepository.findAll();    }

    @Override
    public Departments getDepartmentbyID(int id) throws Exception {
        Optional<Departments> departmentsDb = this.departmentRepository.findById(id);

        if (departmentsDb.isPresent()) {
            return departmentsDb.get();
        } else {
            throw new Exception("Department details not found " + id);
        }
    }

    @Override
    public void deleteDepartment(int id) throws Exception {
            Optional<Departments> departmentsDb = this.departmentRepository.findById(id);

            if(departmentsDb.isPresent()) {
                this.departmentRepository.delete(departmentsDb.get());
            }else {
                throw new Exception("Department details not found " + id);

            }
        }

    }
