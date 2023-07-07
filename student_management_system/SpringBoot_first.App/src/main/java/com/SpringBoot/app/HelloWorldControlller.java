package com.SpringBoot.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldControlller {

	//get HTTP method
	
	@GetMapping("/")
	public String helloWorld()
	{
	return "Hello World";	
	}
}

package com.EmployeeDetails.CRUD.API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductDetailsCrudJavaGauidApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductDetailsCrudJavaGauidApplication.class, args);
	}

}