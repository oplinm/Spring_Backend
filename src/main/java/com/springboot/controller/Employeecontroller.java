package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Employee;
import com.springboot.service.Employeeservice;

@RestController
@RequestMapping("/api")
public class Employeecontroller {
      @Autowired
	private Employeeservice employeeservice;

	/*
	 * public Employeecontroller(Employeeservice employeeservice) { super();
	 * this.employeeservice = employeeservice; }
	 */
	
	@PostMapping("/employees")
	
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee)
	{
		
	//	return new ResponseEntity<Employee>(employeeservice.saveEmployee(employee),HttpStatus.CREATED) ;
	
		System.out.println("Hi amaan");
		System.out.println("Hi amaan"+employee);
		
		
	String s=	employeeservice.saveEmployee(employee);
	System.out.println("Hi amaan");
	
	return new ResponseEntity(s,HttpStatus.OK);
		
	}
      
      //build get all employee
	@GetMapping("/getAll")
	public List<Employee> getAllEmployee()
	{
		System.out.println("hhhh"+employeeservice);
		
		return employeeservice.getAllEmployees();
	
	}
	
	
	//build get employee by id
	
	@GetMapping("/get/{id}")
	
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeid)
	{
		return new ResponseEntity<Employee>(employeeservice.getEmployeeByID(employeeid),HttpStatus.OK);
		
	}
	
	
	@PutMapping("/getu/{id}")
	public ResponseEntity<String> updateemployee(@PathVariable("id") long uid,@RequestBody Employee  employee)
	{
		return new ResponseEntity<String>(employeeservice.updateEmployee(employee, uid),HttpStatus.OK);
		
	}
	
	
	@DeleteMapping("/empdel/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long eid)
	{
		employeeservice.deleteemployee(eid);
		return new ResponseEntity<String>("employee delete sucessfully",HttpStatus.OK);
	}
	
	
	
}
