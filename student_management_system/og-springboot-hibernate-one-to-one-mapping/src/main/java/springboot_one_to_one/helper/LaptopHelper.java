package springboot_one_to_one.helper;

import jakarta.persistence.Entity;

@Entity
public class LaptopHelper {

	private int id;
	private String brand;
	private String model;
	public LaptopHelper(String brand, String model) {
		super();
		this.brand = brand;
		this.model = model;
	}
	
	public LaptopHelper()
	{
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
}
