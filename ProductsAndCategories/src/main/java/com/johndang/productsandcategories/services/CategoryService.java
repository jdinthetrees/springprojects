package com.johndang.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johndang.productsandcategories.models.Category;
import com.johndang.productsandcategories.models.Product;
import com.johndang.productsandcategories.repos.CategoryRepo;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepo; 
	
	
	//get all
	public List<Category> allCategories() {
		return categoryRepo.findAll();
	}
	
	//find by Id
	public Category findById(Long id) {
		Optional<Category> category = categoryRepo.findById(id);
		if(category.isPresent()) {
			return category.get();
		}else {
			return null;
		}
	}
	
	//create and update
	public Category save(Category category) {
		return categoryRepo.save(category);
		
	}
	//delete
	public void delete(Long id) {
		categoryRepo.deleteById(id);
	}
	
	//find categories not in products
	public List<Category> findCategoryNotInProduct(Product product) {
		return categoryRepo.findByProductsNotContains(product);
	}
	
	//find categories not in products
	public List<Category> findCategoryInProduct(Product product) {
		return categoryRepo.findByProductsContains(product);
	}

	
	
	// Add Product to a category
	public void addProductToCategory(Product product, Category category) {
		// get the List of products  from the category model
		List<Product> products = category.getProducts();
		//add the category to the product
		products.add(product);
		// Update the DB
		categoryRepo.save(category);
	}

}
