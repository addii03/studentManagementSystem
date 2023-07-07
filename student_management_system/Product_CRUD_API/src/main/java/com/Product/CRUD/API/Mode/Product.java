package com.Product.CRUD.API.Mode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	
	@Column (name ="p_name")
	private String p_name;
	
	@Column (name ="p_price")
	private float p_price;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
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

	public Product(int pid, String p_name, float p_price) {
		super();
		this.pid = pid;
		this.p_name = p_name;
		this.p_price = p_price;
	}
	public Product()
	{
		
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", p_name=" + p_name + ", p_price=" + p_price + "]";
	}
	
}
