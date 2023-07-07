package com.student_to_laptop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "jpa_student")
public class Student {

	@Id

	private int StudentId;
	private String StudentName;
	private String about;

	@OneToOne(mappedBy = "student")
	private Laptop laptop;

	public Student(int studentId, String studentName, String about, Laptop laptop) {
		super();
		StudentId = studentId;
		StudentName = studentName;
		this.about = about;
		this.laptop = laptop;
	}

	public Student() {

	}

	public int getStudentId() {
		return StudentId;
	}

	public void setStudentId(int studentId) {
		StudentId = studentId;
	}

	public String getStudentName() {
		return StudentName;
	}

	public void setStudentName(String studentName) {
		StudentName = studentName;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

}
