package student_management_system.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import student_management_system.entity.Subject;
import student_management_system.exception.CustomStudentManagementException;
import student_management_system.helper.SubjectHelper;
import student_management_system.repository.SubjectRepository;
import student_management_system.request.SubjectRequest;
import student_management_system.responce.SubjectResponce;
import student_management_system.service.SubejctService;

@Service
public class SubejctServiceImpl implements SubejctService {

	@Autowired
	SubjectRepository subjectRepository;
	
	@Autowired
	SubjectHelper subjectHelper;

	@Override
	public SubjectResponce saveSubjects(SubjectRequest subjectRequest) throws CustomStudentManagementException {
		Subject subject = subjectHelper.toEntity(subjectRequest);
		subjectRepository.save(subject);
		return subjectHelper.toDto(subject);
	}

	@Override
	public List<SubjectResponce> getAllSubject() {
		List<Subject> list = subjectRepository.findAll();
		return list.stream().map(subjectHelper::toDto).collect(Collectors.toList());
	}
	
}
