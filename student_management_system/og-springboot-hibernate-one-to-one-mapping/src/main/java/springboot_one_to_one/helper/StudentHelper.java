package springboot_one_to_one.helper;

import jakarta.persistence.Entity;

@Entity

public class StudentHelper {

	private int id;
	private String name;
	private String gender;
	private String city;

	public StudentHelper(String name, String gender, String city) {
		super();
		this.name = name;
		this.gender = gender;
		this.city = city;
	}

	public StudentHelper()
	{

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
