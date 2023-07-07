package com.SpringBoot.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.SpringBoot.backend.exception.ResorceNotFoundException;
import com.SpringBoot.backend.model.Employee;
import com.SpringBoot.backend.repository.employee_Repository;
import com.SpringBoot.backend.service.employeeService;

@Service
public class EmployeeServiceImpl implements employeeService {

	private employee_Repository repository;
	
	
	public EmployeeServiceImpl(employee_Repository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public Employee saveEmploye(Employee employee) {
		return repository.save(employee);
		
	}

	@Override
	public List<Employee> getAllemployee() {
		return repository.findAll();
	}

	@Override
	public Employee getEmplyeById(int id) {
		Optional<Employee> employe = repository.findById(id);
		if (employe.isPresent())
		{
			return employe.get();
		}
		else
		{
			throw new ResorceNotFoundException("Employee", "id", id);
		}
	}

	@Override
	public Employee updateEmployee(Employee employee, int id) {
		
		// we need to check weather the id present in table or not
		Employee employee2 = repository.findById(id).orElseThrow(()-> new ResorceNotFoundException("Employee", "id", id));
		employee2.setFirstName(employee.getFirstName());
		employee2.setLastName(employee.getLastName());
		employee2.setEmail(employee.getEmail());
		
		//save updated details 
		repository.save(employee2);
		return employee2;
	}

	@Override
	public void deleteEmployee(int id) {
	 repository.findById(id).orElseThrow(()-> new ResorceNotFoundException("Employee", "id", id));
	 repository.deleteById(id);
	 
	}

}
