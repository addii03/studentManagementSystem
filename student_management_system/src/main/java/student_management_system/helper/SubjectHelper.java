package student_management_system.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import student_management_system.entity.Standard;
import student_management_system.entity.Subject;
import student_management_system.entity.Teacher;
import student_management_system.exception.CustomStudentManagementException;
import student_management_system.repository.StandardRepository;
import student_management_system.repository.SubjectRepository;
import student_management_system.repository.TeacherRepository;
import student_management_system.request.SubjectRequest;
import student_management_system.responce.SubjectResponce;

@Component
public class SubjectHelper {

	@Autowired
	SubjectRepository subjectRepository;

	@Autowired
	TeacherRepository teacherRepository;
	
	@Autowired
	StandardRepository standardRepository;

	/// @Autowired

	public Subject toEntity(SubjectRequest subjectRequest) throws CustomStudentManagementException {
		Subject subject = new Subject();
		if (subjectRequest.getSubjectId() != null) {
			subjectRepository.findById(subjectRequest.getSubjectId())
					.orElseThrow(() -> new CustomStudentManagementException("subject id not found"));
		}
		subject.setSubjectName(subjectRequest.getSubjectName());

		//standard mapping
		Standard standard = standardRepository.findById(subjectRequest.getSubjectId())
				.orElseThrow(() -> new CustomStudentManagementException("standard id not found"));
		subject.setStandard(standard);

		Teacher teacher= teacherRepository.findById(subjectRequest.getTeacherId()).orElseThrow(()-> new CustomStudentManagementException("teacher id not found"));
		subject.setTeacher(teacher);
		// subject.setStandard(standardRepository.getReferenceById(subjectRequest.getStandardId()));
		return subject;

	}

	public SubjectResponce toDto(Subject subject) {
		SubjectResponce subjectResponce = new SubjectResponce();
		subjectResponce.setSubjectId(subject.getSubjectId());
		subjectResponce.setSubjectName(subject.getSubjectName());

		//standard mapping
		subjectResponce.setStandardId(subject.getStandard().getStandardId());
		subjectResponce.setStandardName(subject.getStandard().getStandardName());
		
		//teacher mapping
		subjectResponce.setTeacherId(subject.getTeacher().getTeacherId());
		subjectResponce.setTeacherGender(subject.getTeacher().getTeacherGender());
		subjectResponce.setTeacherName(subject.getTeacher().getTeacherName());
		subjectResponce.setTeacherStaffNo(subject.getTeacher().getTeacherStaffNo());
		///subjectResponce.setTeacherDateOfJoining(subject.getTeacher().getTeacherDateOfJoining());
		
		return subjectResponce;

	}
}
