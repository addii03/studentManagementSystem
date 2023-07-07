package com.students.details.service;

import java.util.List;

import com.students.details.request.StudentRequest;
import com.students.details.responce.StudentResponce;

public interface StudentService {

	StudentResponce createNewStudent (StudentRequest studentRequest);
	List<StudentResponce> getALLstudents();
	StudentResponce getStudentById(int id);
	StudentResponce updateStudent(int id , StudentRequest studentRequest);
	void deleteBYId(int id);
	
}
