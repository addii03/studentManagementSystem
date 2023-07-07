package com.students.details.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.students.details.exception.ResorceNotFoundException;
import com.students.details.helper.StudentHelper;
import com.students.details.model.Student;
import com.students.details.repository.StudentRepository;
import com.students.details.request.StudentRequest;
import com.students.details.responce.StudentResponce;
import com.students.details.service.StudentService;

@Service
public class StudentImpl implements StudentService {

	private StudentRepository studentRepository;
	private final StudentHelper studentHelper;
	public StudentImpl(StudentRepository studentRepository, StudentHelper studentHelper) {
		super();
		this.studentRepository = studentRepository;
		this.studentHelper = studentHelper;
	}
	
	//create
	@Override
	public StudentResponce createNewStudent(StudentRequest studentRequest) {
		Student studentFromRequest = studentHelper.getStudentFromRequest(studentRequest);
		studentRepository.save(studentFromRequest);
		return studentHelper.getResponceFromStudent(studentFromRequest);
	}

	@Override
	public List<StudentResponce> getALLstudents() {
		List<Student> studentslist = studentRepository.findAll();
		List<StudentResponce> studentResponces= studentslist.stream().map(s-> {
			StudentResponce studentResponce = new StudentResponce(s.getId(),s.getName(),s.getAge(),s.getCity());
			return studentResponce; 
		}).collect(Collectors.toList());
		return studentResponces;
	}

	@Override
	public StudentResponce getStudentById(int id) {
		Student student = studentRepository.findById(id).orElseThrow(()-> new ResorceNotFoundException("Student", "id", id));
		StudentHelper studentHelper= new StudentHelper();
		StudentResponce responceFromStudent = studentHelper.getResponceFromStudent(student);
		return responceFromStudent;
		
	}

	@Override
	public StudentResponce updateStudent(int id, StudentRequest studentRequest) {
	Student student = studentRepository.findById(id).orElseThrow(()->new ResorceNotFoundException("Student", "id", id));
	StudentHelper studentHelper = new  StudentHelper();
	StudentResponce responceFromStudent = studentHelper.getResponceFromStudent(student);
	return responceFromStudent;
	
	}

	@Override
	public void deleteBYId(int id) {
		Student student = studentRepository.findById(id).orElseThrow(()-> new ResorceNotFoundException("Student", "id", id));
//		StudentHelper studentHelper = new  StudentHelper();
//		StudentResponce responceFromStudent = studentHelper.getResponceFromStudent(student);
		studentRepository.deleteById(id);
		
		
	}


	
	
}
