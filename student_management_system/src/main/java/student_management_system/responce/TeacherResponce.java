package student_management_system.responce;


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
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TeacherResponce {
	Integer teacherId;

	Integer teacherStaffNo;

	String teacherName;
	String teacherGender;

	boolean deleted;

	// standard
	Integer standardId;
	String standardName;

	// student
	Integer student_id;
	Integer studentAge;
	Integer studentRegNo;

	String studentName;
	String studentGender;
	String studentCatagery;
	String studentParentName;

	String studetAcademicYear;
	
	Integer subjectId;
	String subjectName;
}
