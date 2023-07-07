package student_management_system.entity;



import org.hibernate.annotations.ColumnDefault;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "standard")
public class Standard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer standardId;
	String standardName;

	@ColumnDefault(value = "0")
	boolean standardDeleted = false;

//	@OneToMany(mappedBy = "standard", cascade = CascadeType.ALL)
//	List<Student> students;

}
