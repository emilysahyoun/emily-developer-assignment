
package com.emilysahyoun.emilydeveloperassignment.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.jetbrains.annotations.NotNull;

@Entity
@Table(name = "Employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id", length =6)
    private int employeeID;
    @Column(name = "first_name", length = 20, nullable = false)
    @NotNull
    @NotBlank(message ="Enter a first name")
    @Size(min=2, max=20, message = "First name should be more than 2 characters")
    private String firstName;
    @Column(name = "last_name", length = 25, nullable = false)
    @NotNull
    @NotBlank(message ="Enter a last name")
    @Size(min=2, max=25, message = "Last name should be more than 2 characters")
    private String lastName;
    @Column(name = "email", length = 25)
    @Email(message = "Email should be valid")
    private String email;
    @Column(name = "phone_number", length = 20)

    private String phoneNumber;
    @Column(name = "hire_date", length =20)
    private String hireDate;
    @Column(name = "salary", length=20)
    @Min(value=1, message = "Salary must be at least 1")
    private double salary;
    @Column(name = "manager_id", length = 6)
    private int managerId;
    @Column(name = "department_id", length = 4)
    private int departmentId;


   Employee()
   {}

    Employee(String firstName, String lastName, String email, String phoneNumber, String hireDate, double salary, int managerId, int departmentId)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hireDate = hireDate;
        this.salary = salary;
        this.managerId = managerId;
        this.departmentId = departmentId;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;

    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public int getDepartmentID() {
        return departmentId;
    }

    public void setDepartmentID(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "Employee [employee id=" + employeeID + ", name=" + firstName +" " + lastName + ", email=" + email
                + ", phone number =" + phoneNumber + ", hire date=" + hireDate + ", salary=" + salary + " ,manager id=" + managerId + ", department id =" + departmentId +"]";
    }
}

