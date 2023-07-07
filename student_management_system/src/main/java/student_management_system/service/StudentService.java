package student_management_system.service;

import java.util.List;


import student_management_system.exception.CustomStudentManagementException;
import student_management_system.request.StudentRequest;
import student_management_system.responce.StudentResponce;

public interface StudentService {

	StudentResponce saveStudents (StudentRequest studentRequest) throws CustomStudentManagementException;
	List<StudentResponce> getAllStudents();
	void softDelete(Integer id) throws CustomStudentManagementException;
	 List<StudentResponce> findAllByDeletedFalse();
}
