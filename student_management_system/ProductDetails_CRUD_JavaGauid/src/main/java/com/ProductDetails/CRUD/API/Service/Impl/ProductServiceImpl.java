package com.ProductDetails.CRUD.API.Service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ProductDetails.CRUD.API.Exception.ResorceNotFoundException;
import com.ProductDetails.CRUD.API.Model.Product;
import com.ProductDetails.CRUD.API.Repository.ProductRepository;
import com.ProductDetails.CRUD.API.Service.ProductService;
import com.ProductDetails.CRUD.API.helper.ProductDetailsHelper;
import com.ProductDetails.CRUD.API.request.ProductDetailsRequest;
import com.ProductDetails.CRUD.API.responce.ProductDetailsResponce;

@Service
public class ProductServiceImpl implements ProductService{

	private ProductRepository  productRepository;
	private final ProductDetailsHelper productDetailsHelper;
	
	public ProductServiceImpl(ProductRepository productRepository, ProductDetailsHelper productDetailsHelper) {
		super();
		this.productRepository = productRepository;
		this.productDetailsHelper = productDetailsHelper;
	}

	//create
	@Override
	public ProductDetailsResponce saveProducts(ProductDetailsRequest productDetailsRequest) {
		Product productDetailFromRequest = productDetailsHelper.getProductDetailFromRequest(productDetailsRequest);
		productRepository.save(productDetailFromRequest);
		return productDetailsHelper.getProductDetailsResponce(productDetailFromRequest);
		
	}
	
	//get all
	@Override
	public List<ProductDetailsResponce> getAllProducts() {
		List<Product> productResponce = productRepository.findAll();
	List<ProductDetailsResponce>productDetailsResponces = productResponce.stream().map(p-> {ProductDetailsResponce productDetailsResponce= new ProductDetailsResponce(p.getId(),p.getP_name(),p.getP_brand(),p.getP_price());
	return productDetailsResponce;}).collect(Collectors.toList());
	return productDetailsResponces;
		
	}

	@Override
	public ProductDetailsResponce getEmployeeById(int id) {
		 Product product = productRepository.findById( id).orElseThrow(()->new ResorceNotFoundException("Product", "id", id));
		 
		 ProductDetailsHelper productDetailsHelper= new ProductDetailsHelper();
		 ProductDetailsResponce productDetailsResponce = productDetailsHelper.getProductDetailsResponce(product);
		 return productDetailsResponce;
		 
	}

	@Override
	public ProductDetailsResponce updateProduct(int id, ProductDetailsRequest productDetailsRequest) {
		Product product2 = productRepository.findById(id).orElseThrow(()-> new ResorceNotFoundException("Product", "id", id));
		ProductDetailsHelper productDetailsHelper = new ProductDetailsHelper();
		ProductDetailsResponce productDetailsResponce = productDetailsHelper.getProductDetailsResponce(product2);
		
		productDetailsResponce.setId(productDetailsRequest.getId());
		productDetailsResponce.setP_name(productDetailsRequest.getP_name());
		productDetailsResponce.setP_brand(productDetailsRequest.getP_brand());
		productDetailsResponce.setP_price(productDetailsRequest.getP_price());
		
		return productDetailsResponce;
//		product2.setP_name(product.getP_name());
//		product2.setP_brand(product.getP_brand());
//		product2.setP_price(product.getP_price());
		
		//return productRepository.save(product2);
		//return product2;
	}

	@Override
	public void deleteEmployeById(int id) {
		
		Product product = productRepository.findById(id).orElseThrow(()-> new ResorceNotFoundException("Product", "id", id));
		productRepository.deleteById(id);
	}


	

	
	

}
