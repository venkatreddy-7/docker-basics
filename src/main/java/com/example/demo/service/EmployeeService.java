package com.example.demo.service;

import java.util.UUID;

import com.example.demo.entity.Employee;

public interface EmployeeService {

	Object test();

	Employee createEmployee(Employee employee);

	Object getAllEmployees();

	Object getEmployeeById(UUID empId);

	Object updateEmployee(UUID empId, Employee employee);

	Object deleteEmployee(UUID empId);

}
