package student_management_system.request;

import java.util.Date;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TeacherRequest {
	Integer teacherId;

	Integer teacherStaffNo;

	String teacherName;
	String teacherGender;

	
	boolean deleted;
	// standard
	Integer standardId;
	// student
	Integer student_id;

	Integer subjectId;
}
