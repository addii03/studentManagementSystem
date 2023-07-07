package student_management_system.request;

import java.util.Date;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@FieldDefaults(level=AccessLevel.PRIVATE)
public class StudentRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer student_id;
	Integer studentAge;
	Integer studentRegNo;
	
	String studentName;
	String studentGender;
	String studentCatagery;
	String studentParentName;
	String studetAcademicYear;
	
	boolean studentDeleted;
	
	//standard
	Integer standardId;
//	String standardName;
//	boolean standardDeleted;
	
	
}
