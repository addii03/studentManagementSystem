package com.SpringBoot.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot.backend.model.Employee;
import com.SpringBoot.backend.service.employeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeController {

	private employeeService employeeService;

	public EmployeController(com.SpringBoot.backend.service.employeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	//build create employee REST API
	
	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee)
	{
		return new ResponseEntity<Employee>(employeeService.saveEmploye(employee), HttpStatus.CREATED);
	}
	
	
	// build get all the employee rest api
	@GetMapping
	public List<Employee>getAllemployee()
	{
		return employeeService.getAllemployee();
	}
	
	
	// build get employee by id
	@GetMapping ("{id}")
	public ResponseEntity<Employee> getEmplyeById(@PathVariable("id") int id)
	{
		return new ResponseEntity<Employee>(employeeService.getEmplyeById(id), HttpStatus.OK);
	}
	
	// build update employe rest  api
	@PutMapping("{id}")
	
	public ResponseEntity<Employee>updateEmployee(@PathVariable int id,@RequestBody Employee employee)
	{
	return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id),HttpStatus.OK);
	
	}
	
	@DeleteMapping ("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int id)
	{
		employeeService.deleteEmployee(id);
		return new ResponseEntity<String>("Employeee deleted successfully", HttpStatus.OK);
	}
}
