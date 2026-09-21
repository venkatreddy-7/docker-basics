package com.example.demo.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    // Test API
    @GetMapping("/test")
    public ResponseEntity<Object> test() {

        return ResponseEntity.ok(employeeService.test());
    }

    // Create employee
    @PostMapping
    public ResponseEntity<Employee> createEmployee(
            @RequestBody Employee employee) {

        Employee savedEmployee = employeeService.createEmployee(employee);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedEmployee);
    }

    // Get all employees
    @GetMapping
    public ResponseEntity<Object> getAllEmployees() {

        return ResponseEntity.ok(
                employeeService.getAllEmployees()
        );
    }

    // Get employee by ID
    @GetMapping("/{empId}")
    public ResponseEntity<Object> getEmployeeById(
            @PathVariable UUID empId) {

        return ResponseEntity.ok(
                employeeService.getEmployeeById(empId)
        );
    }

    // Update employee
    @PutMapping("/{empId}")
    public ResponseEntity<Object> updateEmployee(
            @PathVariable UUID empId,
            @RequestBody Employee employee) {

        return ResponseEntity.ok(
                employeeService.updateEmployee(empId, employee)
        );
    }

    // Delete employee
    @DeleteMapping("/{empId}")
    public ResponseEntity<Object> deleteEmployee(
            @PathVariable UUID empId) {

        return ResponseEntity.ok(
                employeeService.deleteEmployee(empId)
        );
    }
}