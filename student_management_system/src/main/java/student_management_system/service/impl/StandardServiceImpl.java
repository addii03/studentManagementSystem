package student_management_system.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import student_management_system.entity.Standard;
import student_management_system.exception.CustomStudentManagementException;
import student_management_system.helper.StandardHelper;
import student_management_system.repository.StandardRepository;
import student_management_system.request.StandardRequest;
import student_management_system.responce.StandardResponce;
import student_management_system.service.StandardService;

@Service
public class StandardServiceImpl implements StandardService {

	@Autowired
	StandardRepository standardRepository;
	@Autowired
	StandardHelper standardHelper;

	@Override
	public StandardResponce saveStandard(StandardRequest standardRequest) throws CustomStudentManagementException {
		Standard standard = standardHelper.toEntity(standardRequest);
		standardRepository.save(standard);
		return standardHelper.toDto(standard);
	}

	@Override
	public List<StandardResponce> getAllStandard() {
		List<Standard> list = standardRepository.findAll();
		return list.stream().map(standardHelper::toDto).collect(Collectors.toList());
	}

}
