package com.SpringBoot.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Student_controller {

	//http://localhost:8080
	//http://localhost:8080/students
	
	@GetMapping("/students")
	public Students getStudents()
	{
		return new Students("aditya", "jamdare");
	}
	
	//http://localhost:8080/studentssk
	@GetMapping("/studentssk")
	public List<Students> getStudentss()
{
	List<Students> students = new ArrayList<>();
	students.add(new Students("aditya", "jamdare"));
	students.add(new Students("vivek", "jaiswal"));
	students.add(new Students("chandu", "jatav"));
	students.add(new Students("sushma", "yadav"));
	students.add(new Students("jainam", "jain"));
	
	return students;
		
}
	}
