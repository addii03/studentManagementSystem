package student_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import student_management_system.exception.CustomStudentManagementException;
import student_management_system.helper.TeacherHelper;
import student_management_system.request.TeacherRequest;
import student_management_system.responce.TeacherResponce;
import student_management_system.service.TeacherService;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {

	@Autowired
	TeacherHelper teacherHelper;
	@Autowired
	TeacherService teacherService;

	@PostMapping("/save")
	public ResponseEntity<TeacherResponce> saveTeachers(@RequestBody TeacherRequest teacherRequest) throws CustomStudentManagementException
	{
		return new ResponseEntity<TeacherResponce>(teacherService.saveTeachers(teacherRequest), HttpStatus.CREATED);
	}
	@GetMapping("/all")
	public List<TeacherResponce> getAllTeachers()
	{
		return teacherService.getAllTeachers();
	}
}
