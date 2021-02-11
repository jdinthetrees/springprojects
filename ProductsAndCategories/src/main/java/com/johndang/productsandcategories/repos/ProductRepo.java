package com.johndang.productsandcategories.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.johndang.productsandcategories.models.Category;
import com.johndang.productsandcategories.models.Product;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long>{
	
	List<Product> findAll();

	List<Product> findByCategoriesNotContains(Category category);

	List<Product> findByCategoriesContains(Category category);
}
