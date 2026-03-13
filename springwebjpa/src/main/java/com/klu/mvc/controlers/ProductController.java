package com.klu.mvc.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klu.mvc.entity.Product;
import com.klu.mvc.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product p) {
        Product saved = service.saveProduct(p);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        return ResponseEntity.ok(service.getProductById(id));
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    @PutMapping("/{id}")
    public Product updateRecord(@PathVariable Long id, @RequestBody Product p) {
        return service.updateProduct(id, p);
    }

    @DeleteMapping("/{id}")
    public void deleteRecord(@PathVariable Long id) {
        service.deleteProduct(id);
    }

    @GetMapping("/category/{category}")
    public List<Product> getCategoryProducts(@PathVariable String category) {
        return service.findByCategory(category);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Product> getProductName(@PathVariable String name) {
        return ResponseEntity.ok(service.findByName(name));
    }

    @GetMapping("/price/{price}")
    public List<Product> getProductGreaterThan(@PathVariable Double price) {
        return service.findByPriceGreaterThan(price);
    }

    @GetMapping("/between")
    public List<Product> getByPriceBetween(@RequestParam double min,
                                           @RequestParam double max) {
        return service.findBypriceBetween(min, max);
    }

    @GetMapping("/namelike/{name}")
    public List<Product> getbyNameLike(@PathVariable String name) {
        return service.findByNameLike(name);
    }
}