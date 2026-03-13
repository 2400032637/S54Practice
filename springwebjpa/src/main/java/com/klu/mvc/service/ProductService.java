package com.klu.mvc.service;

import java.util.List;

import com.klu.mvc.entity.Product;

public interface ProductService {
	Product getProductById(Long id);
	List<Product> getAllProducts();
	Product updateProduct(Long id,Product p);
	void deleteProduct(Long id);
	List<Product> findByCategory(String category);
	List<Product>findByPriceGreaterThan(double price);
	Product findByName(String name);
	List<Product>findBypriceBetween(double min,double max);
	List<Product>findByNameLike(String name);
	Product saveProduct(Product p);
}
