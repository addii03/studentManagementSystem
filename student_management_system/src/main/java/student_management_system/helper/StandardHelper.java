package student_management_system.helper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import student_management_system.entity.Standard;

import student_management_system.exception.CustomStudentManagementException;
import student_management_system.repository.StandardRepository;
import student_management_system.repository.StudentRepository;
import student_management_system.request.StandardRequest;
import student_management_system.responce.StandardResponce;

@Component
public class StandardHelper {

	@Autowired
	StandardRepository standardRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	public Standard toEntity (StandardRequest standardRequest) throws CustomStudentManagementException
	{
		Standard standard= new Standard();
		if(standardRequest.getStandardId()!=null)
		{
			standardRepository.findById(standardRequest.getStandardId()).orElseThrow(()-> new CustomStudentManagementException("this standard id not found"));
		}
		standard.setStandardName(standardRequest.getStandardName());
		standard.setStandardDeleted(false);
		//List<Student> students = studentRepository.findByStudentIdIn(standardRequest.getStudentIds());
		//standard.setStudents(students);
		
		//standard.setStudents(studentRepository.getReferenceById(standardRequest.getStudent_id()));
		return standard;
	}
	
	public StandardResponce toDto(Standard standard)
	{
		StandardResponce standardResponce=new StandardResponce();
		standardResponce.setStandardId(standard.getStandardId());
		standardResponce.setStandardName(standard.getStandardName());
		standardResponce.setStandardDeleted(false);
		return standardResponce;
		
		//standardResponce.setStudent_id(standard.getStudents());
	}
}
