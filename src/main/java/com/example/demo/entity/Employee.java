package com.example.demo.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "emp_id")
    private UUID empId;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "mobile", length = 15)
    private String mobile;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    public Employee() {
    }

    public Employee(UUID empId, String employeeName, String mobile, String email) {
        this.empId = empId;
        this.employeeName = employeeName;
        this.mobile = mobile;
        this.email = email;
    }

    public UUID getEmpId() {
        return empId;
    }

    public void setEmpId(UUID empId) {
        this.empId = empId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}