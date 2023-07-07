package com.students.details.helper;

import org.springframework.stereotype.Component;

import com.students.details.model.Student;
import com.students.details.request.StudentRequest;
import com.students.details.responce.StudentResponce;

@Component
public class StudentHelper {

	public Student getStudentFromRequest (StudentRequest studentRequest)
	{
		Student student= new  Student();
		student.setId(studentRequest.getId());
		student.setName(studentRequest.getName());
		student.setAge(studentRequest.getAge());
		student.setCity(studentRequest.getCity());
		return student;
		
	}
	public StudentResponce getResponceFromStudent (Student student)
	{
		StudentResponce studentResponce= new StudentResponce();
		studentResponce.setId(student.getId());
		studentResponce.setName(student.getName());
		studentResponce.setAge(student.getAge());
		studentResponce.setCity(student.getCity());
		return studentResponce;
	}
}
