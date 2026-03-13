package com.klu.mvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.mvc.entity.Product;
import com.klu.mvc.exception.ProductNotFoundException;
import com.klu.mvc.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepo productRepo;
	

	@Override
	public Product saveProduct(Product p) {
		return productRepo.save(p);
	}

	@Override
	public Product getProductById(Long id) {
		// TODO Auto-generated method stub
		Optional<Product> product=productRepo.findById(id);
		return product.orElseThrow(()->new ProductNotFoundException(id+"Product Not found"));
		
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}

	@Override
	public Product updateProduct(Long id, Product p) {
		// TODO Auto-generated method stub
		Product existing=getProductById(id);
		if(existing!=null) {
			existing.setName(p.getName());
			existing.setCategory(p.getCategory());
			existing.setQuantity(p.getQuantity());
			existing.setPrice(p.getPrice());
			return productRepo.save(existing);
			
		}
		return null;
	}

	@Override
	public void deleteProduct(Long id) {
		// TODO Auto-generated method stub
		productRepo.deleteById(id);
		
	}

	public List<Product> findByPriceGreaterThan(Double price) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> findByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	public Product findByName(String name) {
		// TODO Auto-generated method stub
		//return productRepo.findByName(name);
		Optional<Product>product=Optional.ofNullable(productRepo.findByName(name));
		return product.orElseThrow(()->new ProductNotFoundException(name+"Product Not Found"));
	}

	@Override
	public List<Product> findByPriceGreaterThan(double price) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findBypriceBetween(double min, double max) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findByNameLike(String name) {
		// TODO Auto-generated method stub
		return productRepo.findByNameLike(name);
	}

}
