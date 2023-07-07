package com.ProductDetails.CRUD.API.helper;

import org.springframework.stereotype.Component;

import com.ProductDetails.CRUD.API.Model.Product;
import com.ProductDetails.CRUD.API.request.ProductDetailsRequest;
import com.ProductDetails.CRUD.API.responce.ProductDetailsResponce;

@Component
public class ProductDetailsHelper {

	public Product getProductDetailFromRequest (ProductDetailsRequest productDetailsRequest)
	{
		Product product= new Product();
		product.setId(productDetailsRequest.getId());
		//System.out.println("***********" + productDetailsRequest.getP_name());
		product.setP_name(productDetailsRequest.getP_name());
		product.setP_brand(productDetailsRequest.getP_brand());
		product.setP_price(productDetailsRequest.getP_price());
		return product;
	}
	public ProductDetailsResponce getProductDetailsResponce (Product product)
	{
		ProductDetailsResponce productDetailsResponce = new ProductDetailsResponce();
		productDetailsResponce.setId(product.getId());
		productDetailsResponce.setP_name(product.getP_name());
		productDetailsResponce.setP_brand(product.getP_brand());
		productDetailsResponce.setP_price(product.getP_price());
		return productDetailsResponce;
	}
}
