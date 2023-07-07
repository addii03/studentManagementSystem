package student_management_system.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import student_management_system.entity.Teacher;
import student_management_system.exception.CustomStudentManagementException;
import student_management_system.helper.TeacherHelper;
import student_management_system.repository.TeacherRepository;
import student_management_system.request.TeacherRequest;
import student_management_system.responce.TeacherResponce;
import student_management_system.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	TeacherHelper teacherHelper;
	@Autowired
	TeacherRepository teacherRepository ;
	@Override
	public TeacherResponce saveTeachers(TeacherRequest teacherRequest) throws CustomStudentManagementException {
		Teacher teacher = teacherHelper .toEntity(teacherRequest);
		teacherRepository.save(teacher);
		return teacherHelper.toDto(teacher);
		
	}
	@Override
	public List<TeacherResponce> getAllTeachers() {
		List<Teacher> list = teacherRepository.findAll();
		return list.stream().map(teacherHelper::toDto).collect(Collectors.toList());
	}
	
}
