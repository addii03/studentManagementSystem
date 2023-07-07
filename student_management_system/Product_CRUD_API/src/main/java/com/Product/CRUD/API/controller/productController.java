package com.Product.CRUD.API.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.Product.CRUD.API.Mode.Product;
import com.Product.CRUD.API.Repository.ProductRepository;

@RestController
@RequestMapping ("/api")
public class productController {

	@Autowired
	ProductRepository productRepository;
	
	//for save all the details in the table
	@PostMapping ("/product")
	public String createNewProduct (@RequestBody Product product)
	{
		productRepository.save(product);
		return "!!! Product table Created in database !!!";
	}
	//for fetch all the details in the table
	
	@GetMapping("/product")
	public ResponseEntity<List<Product>> getAllProduct()
	{
		List<Product> list= new ArrayList<>();
		//for using stream API
		//productRepository.findAll().forEach(list::add);
		
		//using normal for-each loop
		List<Product> findAll = productRepository.findAll();
		for (Product product : findAll) {
			
			list.add(product);	
		}
		return new ResponseEntity<List<Product>>(list,HttpStatus.OK);
	}
	
	//get the values by using id
	

	@GetMapping("/product/{pid}")
	public ResponseEntity<Product> getProductById(@PathVariable int pid){
		Optional<Product> findById = productRepository.findById(pid);
		
		if (findById.isPresent())
		{
			return new ResponseEntity<Product>(findById.get(),HttpStatus.FOUND);
		}
		else {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
	}
	
	//delete product by using id
	
	@DeleteMapping("/product/{pid}")
	public String deleteProductById(@PathVariable int pid)
	{
		productRepository.deleteById(pid);
		return "product deletes successfully";
	}
	@PutMapping("/product/{pid}")
	public String updateProductByid(@PathVariable int pid,@RequestBody Product product)
	{
		Optional<Product> findById = productRepository.findById(pid);
		
		if (findById.isPresent())
		{
			Product product2 = findById.get();
			product2.setP_name(product.getP_name());
			product2.setP_price(product.getP_price());
			productRepository.save(product2);
			return "Employee details against Id :" + pid + " updated";
		}
		
		else {
			return "employee details does not exist for empid " + pid;
		}
	}
}
