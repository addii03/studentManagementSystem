package com.ProductDetails.CRUD.API.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ProductDetails.CRUD.API.Model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}




