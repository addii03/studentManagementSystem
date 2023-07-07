package com.Product.CRUD.API.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Product.CRUD.API.Mode.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
