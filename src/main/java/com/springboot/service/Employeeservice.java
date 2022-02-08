package com.springboot.service;

import java.util.List;

import com.springboot.model.Employee;

public interface Employeeservice {
	String saveEmployee(Employee employee);
	
	List<Employee> getAllEmployees();
	
	
	Employee getEmployeeByID(long id);
	
	String updateEmployee(Employee employee,long id);
	
	void deleteemployee(long id);

}
