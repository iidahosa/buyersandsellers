package com.bns.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bns.repository.ProductRepository;
import com.bns.models.Product;
import com.bns.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> findAll() {
		List<Product> ProductList = (List<Product>) productRepository.findAll();
		List<Product> activeBookList = new ArrayList<>();
		
		for (Product product: ProductList) {
			if(product.isActive()) {
				activeBookList.add(product);
			}
		}
		
		return activeBookList;
	}
	
	public Product findOne(Long id) {
		return productRepository.findOne(id);
	}

	public List<Product> findByCategory(String category){
		List<Product> ProductList = productRepository.findByCategory(category);
		
		List<Product> activeproductList = new ArrayList<>();
		
		for (Product product: ProductList) {
			if(product.isActive()) {
				activeproductList.add(product);
			}
		}
		
		return activeproductList;
	}
	
	public List<Product> blurrySearch(String title) {
		List<Product> productList = productRepository.findByTitleContaining(title);
List<Product> activeBookList = new ArrayList<>();
		
		for (Product book: productList) {
			if(book.isActive()) {
				activeBookList.add(book);
			}
		}
		
		return activeBookList;
	}
}
