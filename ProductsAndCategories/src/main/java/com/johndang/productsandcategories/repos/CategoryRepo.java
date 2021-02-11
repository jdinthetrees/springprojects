package com.johndang.productsandcategories.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.johndang.productsandcategories.models.Category;
import com.johndang.productsandcategories.models.Product;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Long>{
	
	List<Category> findAll();
	List<Category> findByProductsNotContains(Product product);
	List<Category> findByProductsContains(Product product);

}
