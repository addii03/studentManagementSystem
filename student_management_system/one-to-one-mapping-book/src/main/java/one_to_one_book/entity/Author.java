package one_to_one_book.entity;

import jakarta.persistence.Column;
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
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "Authors")
@FieldDefaults(level=AccessLevel.PRIVATE)
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer authorId;
	
	@Column(name="first_Name")
	String firstName;
	@Column(name="lastName")
	String lastName;
	@Column(name="language")
	String language;
	

	
}
