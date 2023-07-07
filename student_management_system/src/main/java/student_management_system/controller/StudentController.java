package student_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;
import student_management_system.exception.CustomStudentManagementException;
import student_management_system.helper.StudentHelper;
import student_management_system.request.StudentRequest;
import student_management_system.responce.StudentResponce;
import student_management_system.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	StudentHelper studentHelper;
	
	@Autowired
	StudentService studentService;
	
	@PostMapping("/save")
	public ResponseEntity<StudentResponce>saveStudents (@RequestBody StudentRequest studentRequest) throws CustomStudentManagementException
	{
		return new ResponseEntity<StudentResponce>(studentService.saveStudents(studentRequest), HttpStatus.CREATED);
	}
	@GetMapping("/all")
	public List<StudentResponce> getAllStudents()
	{
		return studentService.getAllStudents();
	}
	@DeleteMapping("/softdelete/{id}")
	public ResponseEntity<String> softDelete(@PathVariable Integer id) throws CustomStudentManagementException
	{
		studentService.softDelete(id);
		return new ResponseEntity<String>("soft deleted successfully", HttpStatus.OK);
	}
	@GetMapping("/deletedfalse")
	public List<StudentResponce> findAllByDeletedFalse() 
	{
		return studentService.findAllByDeletedFalse();
	}
}
