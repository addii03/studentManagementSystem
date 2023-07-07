package com.ProductDetails.CRUD.API.request;

public class ProductDetailsRequest {

	private int id;
	private String p_name;
	private String p_brand;
	private float p_price;
	
	public float getP_price() {
		return p_price;
	}
	public void setP_price(float p_price) {
		this.p_price = p_price;
	}
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
	public String getP_brand() {
		return p_brand;
	}
	public void setP_brand(String p_brand) {
		this.p_brand = p_brand;
	}
	public ProductDetailsRequest(int id, String p_name, String p_brand, float p_price) {
		super();
		this.id = id;
		this.p_name = p_name;
		this.p_brand = p_brand;
		this.p_price = p_price;
	}
	public ProductDetailsRequest() {
		
	}
	
}
