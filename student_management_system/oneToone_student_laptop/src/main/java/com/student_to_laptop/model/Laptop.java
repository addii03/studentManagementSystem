package com.student_to_laptop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "jpa_laptop")
public class Laptop {

	@Id
	private int LaptopID;
	private String model;
	private String Brand;
	
	@OneToOne
	@JoinColumn (name ="Student_id")
	private Student student;

	public Laptop(int laptopID, String model, String brand, Student student) {
		super();
		LaptopID = laptopID;
		this.model = model;
		Brand = brand;
		this.student = student;
	}

	public int getLaptopID() {
		return LaptopID;
	}

	public void setLaptopID(int laptopID) {
		LaptopID = laptopID;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	
}
