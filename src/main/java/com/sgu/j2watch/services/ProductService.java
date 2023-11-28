package com.sgu.j2watch.services;

import java.util.List;

import com.sgu.j2watch.entities.Product;



public interface ProductService {
    List<Product> findAll();
    Product findById(int id);
    Product save(Product product);
    void deleteById(int id);
	Product getProductById(Integer id_product);
	List<Product> getAllProducts();
	void saveProduct(Product product);
	void updateProduct(Product product);
	void deleteProduct(Integer id_product);
	List<Product> getProductsByBrandId(Integer brand_id);
	List<Product> getProductsByCategoryId(Integer category_id);
}