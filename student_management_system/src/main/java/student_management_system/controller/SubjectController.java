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
import student_management_system.helper.SubjectHelper;
import student_management_system.request.SubjectRequest;
import student_management_system.responce.SubjectResponce;
import student_management_system.service.SubejctService;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {

	@Autowired
	SubjectHelper subjectHelper ;
	@Autowired
	SubejctService subejctService ;
	
	@PostMapping("/save")
	public ResponseEntity<SubjectResponce> saveSubjects(@RequestBody SubjectRequest subjectRequest) throws CustomStudentManagementException
	{
		return new ResponseEntity<SubjectResponce>(subejctService.saveSubjects(subjectRequest),HttpStatus.CREATED);
	}
	@GetMapping("all")
	public List<SubjectResponce> getAllSubject() 
	{
		return subejctService.getAllSubject();
	}
}
