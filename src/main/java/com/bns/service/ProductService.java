package com.bns.service;

import java.util.List;
import java.util.Optional;

import com.bns.models.*;

public interface ProductService {
	List<Product> findAll ();
	
	Optional<Product> findOne(Long id);
	
	List<Product> findByCategory(String category);
	
	List<Product> blurrySearch(String title);
}
