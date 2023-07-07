package student_management_system.service;

import java.util.List;

import student_management_system.exception.CustomStudentManagementException;
import student_management_system.request.TeacherRequest;
import student_management_system.responce.TeacherResponce;

public interface TeacherService {

	TeacherResponce saveTeachers(TeacherRequest teacherRequest) throws CustomStudentManagementException;
	List<TeacherResponce> getAllTeachers();
}
