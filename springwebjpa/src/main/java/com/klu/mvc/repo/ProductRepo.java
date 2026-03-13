package com.klu.mvc.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.klu.mvc.entity.Product;

@Repository


public interface ProductRepo extends JpaRepository<Product , Long> {

    @Query("SELECT p FROM Product p WHERE p.category = :category")
    List<Product> findByCategory(String category);
	List<Product>findByPriceGreaterThan(double price);
	Product findByName(String name);
	@Query("SELECT p FROM Product p where p.price BETWEEN:min AND :max")
	List<Product>findBypriceBetween(@Param("min") double min,double max);
	@Query("SELECT p FROM Product p where p.name LIKE CONCAT('%',:name,'%')")
	List<Product> findByNameLike(@Param("name")String name);
	
}
