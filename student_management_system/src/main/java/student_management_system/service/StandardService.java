package student_management_system.service;

import java.util.List;

import student_management_system.exception.CustomStudentManagementException;
import student_management_system.request.StandardRequest;
import student_management_system.responce.StandardResponce;

public interface StandardService {

	StandardResponce saveStandard(StandardRequest standardRequest) throws CustomStudentManagementException;
	List<StandardResponce> getAllStandard();
}
