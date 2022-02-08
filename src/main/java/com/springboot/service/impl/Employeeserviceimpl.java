package com.springboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.exception.ResourceNotfoundException;
import com.springboot.model.Employee;
import com.springboot.repository.EmployeeRepository;
import com.springboot.service.Employeeservice;

@Service
public class Employeeserviceimpl implements Employeeservice {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	/*
	 * 
	 * public Employeeserviceimpl(EmployeeRepository employeeRepository) { super();
	 * this.employeeRepository = employeeRepository; }
	 */
	

	//@Override
	public String  saveEmployee(Employee employee) {
		
		
		
		System.out.println("amaan"+employee);
		
		 employeeRepository.save(employee);
		 return "user sucessfully reg";
	}


    
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		System.out.println("this the mehod");
		return employeeRepository.findAll();
	}



	@Override
	public Employee getEmployeeByID(long id) {
		
		
		return employeeRepository.findById(id).orElseThrow();
	}



	@Override
	public String updateEmployee(Employee employee, long id) {
		// TODO Auto-generated method stub
		Employee employee1=employeeRepository.findById(id).orElseThrow(
				()-> new ResourceNotfoundException("employee not found","id", id));
		employee1.setFirstname(employee.getFirstname());
		employee1.setLastname(employee.getLastname());
		employee1.setEmail(employee.getEmail());
		employeeRepository.save(employee1);
		return "update sucessfully employee";
	}



	@Override
	public void deleteemployee(long id) {
		
		
		employeeRepository.findById(id).orElseThrow(()->new ResourceNotfoundException("employee not found","id",id));
		employeeRepository.deleteById(id);
		
	}


}
