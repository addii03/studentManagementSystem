package student_management_system.entity;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "student_Data")
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Student {
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
	

	@Column(name = "deleted", columnDefinition = "TINYINT(1)")
	boolean studentDeleted = false;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "standard_id")
	Standard standard;

//	@OneToMany(cascade = CascadeType.ALL)
//	List<Teacher> teachers;
}
