package student_management_system.responce;

import java.util.Date;
import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import student_management_system.entity.Student;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class StandardResponce {

	Integer standardId;
	String standardName;
	boolean standardDeleted;
	//students
	Integer student_id;
	Integer studentAge;
	Integer studentRegNo;
	
	String studentName;
	String studentGender;
	String studentCatagery;
	String studentParentName;

	Date studetAcademicYear;
	Date studentDateOfAdmission;
	Date studentDob;
	boolean studentDeleted;
	
	List<Student> students;
}
