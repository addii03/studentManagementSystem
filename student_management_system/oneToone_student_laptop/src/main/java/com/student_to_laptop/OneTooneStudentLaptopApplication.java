package com.student_to_laptop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.student_to_laptop.model.Student;
import com.student_to_laptop_repository.StudentRepository;

@SpringBootApplication
public class OneTooneStudentLaptopApplication {
	
	@Autowired
	private StudentRepository studentRepository;
	
//	public OneTooneStudentLaptopApplication(StudentRepository studentRepository) {
//		super();
//		this.studentRepository = studentRepository;
//	}

	public static void main(String[] args) {
		SpringApplication.run(OneTooneStudentLaptopApplication.class, args);
		
		
		
		
	}
}
