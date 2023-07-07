package student_management_system.request;

import java.util.Date;
import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class StandardRequest {

	Integer standardId;
	String standardName;	
	boolean standardDeleted;
	
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
	
	List<Integer> studentIds;
	
}
