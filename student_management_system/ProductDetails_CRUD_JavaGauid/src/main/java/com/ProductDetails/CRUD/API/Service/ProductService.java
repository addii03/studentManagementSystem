package com.ProductDetails.CRUD.API.Service;

import java.util.List;

import com.ProductDetails.CRUD.API.Model.Product;
import com.ProductDetails.CRUD.API.request.ProductDetailsRequest;
import com.ProductDetails.CRUD.API.responce.ProductDetailsResponce;

public interface ProductService {

	ProductDetailsResponce saveProducts(ProductDetailsRequest productDetailsRequest);

	List<ProductDetailsResponce> getAllProducts();
	
	ProductDetailsResponce getEmployeeById(int id);
	ProductDetailsResponce updateProduct (int id, ProductDetailsRequest productDetailsRequest);
	void deleteEmployeById(int id);
	
}
