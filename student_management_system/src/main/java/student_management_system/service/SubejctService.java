package student_management_system.service;

import java.util.List;

import student_management_system.exception.CustomStudentManagementException;
import student_management_system.request.SubjectRequest;
import student_management_system.responce.SubjectResponce;

public interface SubejctService {

	SubjectResponce saveSubjects(SubjectRequest subjectRequest) throws CustomStudentManagementException;
	List<SubjectResponce> getAllSubject();
	
}
