package com.ProductDetails.CRUD.API.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name= "products")
public class Product {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="p_name")
	private String p_name;
	
	@Column(name="p_price")
	private float p_price;
	
	@Column(name="p_brand")
	private String p_brand;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public float getP_price() {
		return p_price;
	}

	public void setP_price(float p_price) {
		this.p_price = p_price;
	}

	public String getP_brand() {
		return p_brand;
	}

	public void setP_brand(String p_brand) {
		this.p_brand = p_brand;
	}

	public Product(int id, String p_name, float p_price, String p_brand) {
		super();
		this.id = id;
		this.p_name = p_name;
		this.p_price = p_price;
		this.p_brand = p_brand;
	}

	public Product() {
		
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", p_name=" + p_name + ", p_price=" + p_price + ", p_brand=" + p_brand + "]";
	}
	
}
