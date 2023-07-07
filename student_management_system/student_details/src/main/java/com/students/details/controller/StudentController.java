package com.students.details.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.students.details.request.StudentRequest;
import com.students.details.responce.StudentResponce;
import com.students.details.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

	private final StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	// create
	@PostMapping("/save")
	public ResponseEntity<StudentResponce> createNewStudent(@RequestBody StudentRequest studentRequest) {
		return new ResponseEntity<StudentResponce>(studentService.createNewStudent(studentRequest), HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public List<StudentResponce> getALLstudents() {
		return studentService.getALLstudents();
	}

	@GetMapping("{id}")
	public ResponseEntity<Object> getStudentById(@PathVariable int id) {
		try {
			return new ResponseEntity<Object>(studentService.getStudentById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping ("/update/{id}")
	
	public ResponseEntity<Object> updateStudent(@PathVariable int id,@RequestBody StudentRequest studentRequest)
	{
		try {
			return new ResponseEntity<Object>(studentService.updateStudent(id, studentRequest), HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping ("/delete/{id}")
	public ResponseEntity<String> deleteBYId(@PathVariable int id)
	{
		try
		{
			studentService.deleteBYId(id);
			return new ResponseEntity<String>("deleted successfully", HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new  ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		
		}
	}
}