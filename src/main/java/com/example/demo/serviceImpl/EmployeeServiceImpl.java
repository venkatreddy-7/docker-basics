package com.example.demo.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.Employeerepository;
import com.example.demo.service.EmployeeService;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService{

	private final Employeerepository employeeRepository;

    // Test method
    public String test() {
        return "Employee Service is working";
    }

    // Create employee
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Get all employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Get employee by ID
    public Employee getEmployeeById(UUID empId) {
        return employeeRepository.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + empId));
    }

    // Update employee
    public Employee updateEmployee(UUID empId, Employee employee) {

        Employee existingEmployee = employeeRepository.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + empId));

        existingEmployee.setEmployeeName(employee.getEmployeeName());
        existingEmployee.setMobile(employee.getMobile());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setPassword(employee.getPassword());

        return employeeRepository.save(existingEmployee);
    }

    // Delete employee
    public String deleteEmployee(UUID empId) {

        Employee existingEmployee = employeeRepository.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + empId));

        employeeRepository.delete(existingEmployee);

        return "Employee deleted successfully";
    }
}
