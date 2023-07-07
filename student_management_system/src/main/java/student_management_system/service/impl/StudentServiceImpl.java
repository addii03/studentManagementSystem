package student_management_system.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import student_management_system.entity.Student;
import student_management_system.exception.CustomStudentManagementException;
import student_management_system.helper.StudentHelper;
import student_management_system.repository.StudentRepository;
import student_management_system.request.StudentRequest;
import student_management_system.responce.StudentResponce;
import student_management_system.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentHelper studentHelper;

	@Autowired
	StudentRepository studentRepository;

	@Override
	public StudentResponce saveStudents(StudentRequest studentRequest) throws CustomStudentManagementException {
		Student student = studentHelper.toEntity(studentRequest);
		studentRepository.save(student);
		return studentHelper.toDto(student);
	}

	@Override
	public List<StudentResponce> getAllStudents() {
		List<Student> list = studentRepository.findAll();
		return list.stream().map(studentHelper::toDto).collect(Collectors.toList());
	}

	@Override
	public void softDelete(Integer id) throws CustomStudentManagementException {
		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new CustomStudentManagementException("student not found with this id :"));
		student.setStudentDeleted(true);
		studentRepository.save(student);
	}

	@Override
	public List<StudentResponce> findAllByDeletedFalse() {
		List<Student> findAllByDeleted = studentRepository.findAllByDeletedFalse(false);
		return findAllByDeleted.stream().map(studentHelper::toDto).collect(Collectors.toList());
	}

}
