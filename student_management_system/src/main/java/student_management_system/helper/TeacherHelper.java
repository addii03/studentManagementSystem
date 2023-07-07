package student_management_system.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import student_management_system.entity.Standard;
import student_management_system.entity.Student;
import student_management_system.entity.Subject;
import student_management_system.entity.Teacher;
import student_management_system.exception.CustomStudentManagementException;
import student_management_system.repository.StandardRepository;
import student_management_system.repository.StudentRepository;
import student_management_system.repository.SubjectRepository;
import student_management_system.repository.TeacherRepository;
import student_management_system.request.TeacherRequest;
import student_management_system.responce.TeacherResponce;

@Component
public class TeacherHelper {

	@Autowired
	TeacherRepository teacherRepository;

	@Autowired
	StandardRepository standardRepository;
	
	@Autowired
	SubjectRepository subjectRepository;
	@Autowired
	StudentRepository studentRepository;
	
	public Teacher toEntity(TeacherRequest teacherRequest) throws CustomStudentManagementException {
		Teacher teacher = new Teacher();
		if (teacherRequest.getTeacherId() != null) {
			teacherRepository.findById(teacherRequest.getTeacherId())
					.orElseThrow(() -> new CustomStudentManagementException("teacher id not found"));
		}
		teacher.setTeacherName(teacherRequest.getTeacherName());
		teacher.setTeacherStaffNo(teacherRequest.getTeacherStaffNo());
		teacher.setTeacherGender(teacherRequest.getTeacherGender());
		//teacher.setTeacherDateOfJoining(teacherRequest.getTeacherDateOfJoining());
		teacher.setDeleted(false);
		
		//standard mapping
		Standard standard = standardRepository.findById(teacherRequest.getStandardId()).orElse(null);
		teacher.setStandard(standard);
		
		// student mapping
		Student student = studentRepository.findById(teacherRequest.getStudent_id()).orElse(null);
		teacher.setStudent(student);
		
		//subject
		
//		Subject subject= subjectRepository.findById(teacherRequest.getSubjectId()).orElseThrow(()-> new CustomStudentManagementException("subject id not found"));
//		teacher.setSubject(subject);
		return teacher;

	}

	public TeacherResponce toDto(Teacher teacher) {
		TeacherResponce teacherResponce = new TeacherResponce();
		teacherResponce.setTeacherId(teacher.getTeacherId());
		teacherResponce.setTeacherName(teacher.getTeacherName());
		teacherResponce.setTeacherStaffNo(teacher.getTeacherStaffNo());
		teacherResponce.setTeacherGender(teacher.getTeacherGender());
		//teacherResponce.setTeacherDateOfJoining(teacher.getTeacherDateOfJoining());
		teacherResponce.setDeleted(false);
		//standard mapping
		teacherResponce.setStandardId(teacher.getStandard().getStandardId());
		teacherResponce.setStandardName(teacher.getStandard().getStandardName());
		
		//student mapping
		teacherResponce.setStudent_id(teacher.getStudent().getStudent_id());
		teacherResponce.setStudentAge(teacher.getStudent().getStudentAge());
		teacherResponce.setStudentRegNo(teacher.getStudent().getStudentRegNo());
		teacherResponce.setStudentName(teacher.getStudent().getStudentName());
		teacherResponce.setStudentGender(teacher.getStudent().getStudentGender());
		teacherResponce.setStudentCatagery(teacher.getStudent().getStudentCatagery());
		teacherResponce.setStudentParentName(teacher.getStudent().getStudentParentName());
//		teacherResponce.setStudentDateOfAdmission(teacher.getStudent().getStudentDateOfAdmission());
		teacherResponce.setStudetAcademicYear(teacher.getStudent().getStudetAcademicYear());
		//teacherResponce.setStudentDob(teacher.getStudent().getStudentDob());
		
		//subject
		
//		teacherResponce.setSubjectId(teacher.getSubject().getSubjectId());
//		teacherResponce.setSubjectName(teacher.getSubject().getSubjectName());
		return teacherResponce;

	}
}
