package com.SpringBoot.backend.service;

import java.util.List;

import com.SpringBoot.backend.model.Employee;

public interface employeeService  {

	Employee saveEmploye(Employee employee);
	List<Employee> getAllemployee();
	Employee getEmplyeById(int id);
	Employee updateEmployee(Employee employee, int id);
	void deleteEmployee(int id);
}
