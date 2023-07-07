package student_management_system.responce;

import java.util.Date;

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
public class SubjectResponce {
	Integer subjectId;
	String subjectName;	
	
	Integer standardId;
	String standardName;
	
	//teacher
	Integer teacherId;
	Integer teacherStaffNo;
	String teacherName;
	String teacherGender;
	Date teacherDateOfJoining;

}
