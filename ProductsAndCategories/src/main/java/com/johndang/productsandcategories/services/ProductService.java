package com.johndang.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johndang.productsandcategories.models.Category;
import com.johndang.productsandcategories.models.Product;
import com.johndang.productsandcategories.repos.ProductRepo;



@Service
public class ProductService {
	
	@Autowired
	private ProductRepo productRepo; 
	
	
	//get all
	public List<Product> allProducts() {
		return productRepo.findAll();
	}
	
	//find by Id
	public Product findById(Long id) {
		Optional<Product> product = productRepo.findById(id);
		if(product.isPresent()) {
			return product.get();
		}else {
			return null;
		}
	}
	
	//create and update
	public Product save(Product product) {
		return productRepo.save(product);
		
	}
	//delete
	public void delete(Long id) {
		productRepo.deleteById(id);
	}
	
	//find products not in categories
		public List<Product> findProductsNotInCategory(Category category) {
			return productRepo.findByCategoriesNotContains(category);
		}
		
		//find products not in categories
		public List<Product> findProductsInCategory(Category category) {
			return productRepo.findByCategoriesContains(category);
		}
		

	// Add Category to a product
	public void addCategoryToProduct(Category category, Product product) {
		// get the List of categories from the product model
		List<Category> categories = product.getCategories();
		//add the category to the product
		categories.add(category);
		// Update the DB
		productRepo.save(product);
	}

}
