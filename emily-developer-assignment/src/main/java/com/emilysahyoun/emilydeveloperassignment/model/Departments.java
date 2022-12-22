package com.emilysahyoun.emilydeveloperassignment.model;

import jakarta.persistence.*;


@Entity
@Table(name = "Departments")
public class Departments {
    @Id
    @Column(name = "department_id", length =4)
    private int departmentID;
    @Column(name = "department_name", length = 30)
    private String departmentName;
    @Column(name = "manager_id",length = 6)
    private int managerID;

    Departments()
    {

    }

    Departments(int departmentID, String departmentName, int managerID)
    {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.managerID = managerID;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getManagerID() {
        return managerID;
    }

    public void setManagerID(int managerID) {
        this.managerID = managerID;
    }

    @Override
    public String toString() {
        return "Department [department id=" + departmentID + ", department name=" + departmentName +
                ", manager id= " + managerID+ "]";
    }

}
