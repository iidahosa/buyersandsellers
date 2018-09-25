package com.bns.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bns.models.*;

public interface ProductRepository extends CrudRepository<Product, Long>{
	List<Product> findByCategory(String category);
	
	List<Product> findByTitleContaining(String title);
}