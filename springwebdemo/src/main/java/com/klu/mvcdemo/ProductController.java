package com.klu.mvcdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")

public class ProductController {
	
	@GetMapping("/{id}")
	public String getProductid(@PathVariable int id) {
		return "<h1>The Requested Product id is:" +id+ "<h1>";
	}
	@GetMapping("/name/{name}")
	public String getproductid(@PathVariable String name) {
		return "<h1>The Requested Product Name is:"+name+"<h1>";
	}
	
}
