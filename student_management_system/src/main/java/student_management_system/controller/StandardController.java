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
import student_management_system.helper.StandardHelper;
import student_management_system.request.StandardRequest;
import student_management_system.responce.StandardResponce;
import student_management_system.service.StandardService;

@RestController
@RequestMapping("/api/standard")
public class StandardController {

	@Autowired
	StandardHelper standardHelper ;
	@Autowired
	StandardService standardService;
	
	@PostMapping("/save")
	public ResponseEntity<StandardResponce> saveStandard(@RequestBody StandardRequest standardRequest) throws CustomStudentManagementException
	{
		return new ResponseEntity<>(standardService.saveStandard(standardRequest), HttpStatus.CREATED);
	}
	@GetMapping("/all")
	public List<StandardResponce> getAllStandard()
	{
		return standardService.getAllStandard();
	}
}
