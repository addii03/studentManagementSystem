package student_management_system.helper;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import student_management_system.entity.Standard;
import student_management_system.entity.Student;
import student_management_system.exception.CustomStudentManagementException;
import student_management_system.repository.StandardRepository;
import student_management_system.repository.StudentRepository;
import student_management_system.request.StudentRequest;
import student_management_system.responce.StudentResponce;

@Component
public class StudentHelper {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	StandardRepository standardRepository;

	public Student toEntity(StudentRequest studentRequest) throws CustomStudentManagementException {
		Student student = new Student();

		if (studentRequest.getStudent_id() != null) {
			studentRepository.findById(studentRequest.getStudent_id())
					.orElseThrow(() -> new CustomStudentManagementException("student not found with this id :"));
		}
		student.setStudent_id(studentRequest.getStudent_id());
		student.setStudentAge(studentRequest.getStudentAge());
		student.setStudentRegNo(studentRequest.getStudentRegNo());
		student.setStudentName(studentRequest.getStudentName());
		student.setStudentGender(studentRequest.getStudentGender());
		student.setStudentCatagery(studentRequest.getStudentCatagery());
		student.setStudentParentName(studentRequest.getStudentParentName());
		student.setStudetAcademicYear(studentRequest.getStudetAcademicYear());
//		student.setStudentDateOfAdmission(studentRequest.getStudentDateOfAdmission());
		//student.setStudentDob(studentRequest.getStudentDob());
		student.setStudentDeleted(false);

		// standard mapping
		Standard standard = standardRepository.findById(studentRequest.getStandardId())
				.orElseThrow(() -> new CustomStudentManagementException("standard not found with this id :"));

		student.setStandard(standard);
		// student.setStandard(standardRepository.getReferenceById(studentRequest.getStandardId()));

		return student;
	}

	public StudentResponce toDto(Student student) {
		StudentResponce studentResponce = new StudentResponce();

		// studentResponce.setStandardId(student.getStudent_id());
		studentResponce.setStudent_id(student.getStudent_id());
		studentResponce.setStudentAge(student.getStudentAge());
		studentResponce.setStudentRegNo(student.getStudentRegNo());
		studentResponce.setStudentName(student.getStudentName());
		studentResponce.setStudentGender(student.getStudentGender());
		studentResponce.setStudentCatagery(student.getStudentCatagery());
		studentResponce.setStudentParentName(student.getStudentParentName());
		studentResponce.setStudetAcademicYear(student.getStudetAcademicYear());
//		studentResponce.setStudentDateOfAdmission(student.getStudentDateOfAdmission());
		//studentResponce.setStudentDob(student.getStudentDob());
		studentResponce.setStudentDeleted(false);

		// standard mapping
		studentResponce.setStandardId(student.getStandard().getStandardId());
		studentResponce.setStandardName(student.getStandard().getStandardName());
		studentResponce.setStandardDeleted(false);
		return studentResponce;
	}
}
