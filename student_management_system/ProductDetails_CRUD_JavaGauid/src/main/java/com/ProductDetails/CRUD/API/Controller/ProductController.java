package com.ProductDetails.CRUD.API.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProductDetails.CRUD.API.Model.Product;
import com.ProductDetails.CRUD.API.Service.ProductService;
import com.ProductDetails.CRUD.API.request.ProductDetailsRequest;
import com.ProductDetails.CRUD.API.responce.ProductDetailsResponce;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	private final ProductService productService;

	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}

	// save all the details of products

	@PostMapping("/save")
	public ResponseEntity<ProductDetailsResponce> saveProducts(@RequestBody ProductDetailsRequest productDetailsRequest) {
		return new ResponseEntity<ProductDetailsResponce>(productService.saveProducts(productDetailsRequest), HttpStatus.CREATED);
	}
	@GetMapping("/get")
	public List<ProductDetailsResponce>getAllProducts()
	{
		return productService.getAllProducts();
	}
	
	@GetMapping ("{id}")
	public ResponseEntity<ProductDetailsResponce> getEmployeeById(@PathVariable int id)
	{
		return new ResponseEntity<ProductDetailsResponce>(productService.getEmployeeById(id),HttpStatus.OK);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<ProductDetailsResponce> updateProduct(@PathVariable int id,@RequestBody ProductDetailsRequest productDetailsRequest)
	{
		return new ResponseEntity<ProductDetailsResponce>(productService.updateProduct(id, productDetailsRequest), HttpStatus.OK);
		
	}
	@DeleteMapping("/delete/{id}")
	
		public ResponseEntity<String> deleteEmployeById(@PathVariable int id)
		{
			productService.deleteEmployeById(id);
			return new ResponseEntity<String>("Deletes successfully", HttpStatus.OK);
		}
	
	
	
		
}
