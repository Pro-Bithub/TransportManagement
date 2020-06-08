package com.prakash.tm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prakash.tm.model.Product;
import com.prakash.tm.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Product save(Product product) {
		return productRepository.save(product);
	}

	public Product findById(long id) {
		return productRepository.findById(id).orElse(null);
	}

	// modified by ghozzi
	public void deleteById(long id) {
		 productRepository.deleteById(id);
	}

	public List<Product> list() {
		return productRepository.findAll();
	}
}