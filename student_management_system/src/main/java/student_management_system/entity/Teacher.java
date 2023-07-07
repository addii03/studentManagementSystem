package student_management_system.entity;

import java.util.Date;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "teacher_data")
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer teacherId;
	Integer teacherStaffNo;
	String teacherName;
	String teacherGender;
	
	@ColumnDefault(value = "0")
	boolean deleted = false;
	
	@ManyToOne(cascade = CascadeType.ALL)
	Standard standard;
	
	@ManyToOne(cascade = CascadeType.ALL)
	Student student;
	
//	@OneToOne(mappedBy ="teacher" ,cascade = CascadeType.ALL)
//	Subject subject;
}
