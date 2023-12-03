package com.sgu.j2watch.services;

import java.util.List;
import java.util.Optional;

import com.sgu.j2watch.entities.Product;



public interface ProductService {
	
	public List<Product> findAll();
	public Product findById(int id);
	public void save(Product product);
	public void deleteById(int id);
	public List<Product> getAllProducts();
	public Optional<Product> getProductById(int id_product);
	public Product saveProduct(Product product);
	public void deleteProduct(int id_product);
	
}