package com.johndang.productsandcategories.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.johndang.productsandcategories.models.Category;
import com.johndang.productsandcategories.models.Product;
import com.johndang.productsandcategories.services.CategoryService;
import com.johndang.productsandcategories.services.ProductService;


@Controller
public class MainController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	
	//must get model model for both products and categories
	@GetMapping("/")
	public String allProducts(Model model) {
		model.addAttribute("products", productService.allProducts());
		model.addAttribute("categories", categoryService.allCategories());
		return "index.jsp";
	}
	
	//this takes form info with help of Model model attribute into form 
	//so that user can update with data
	@GetMapping("/products/new")
	public String showProductCreate(@ModelAttribute("product") Product product) {
		return "newProduct.jsp";
	}
	
	//place where submitted form info goes to
	@PostMapping("/products")
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "newProduct.jsp";
		}
		productService.save(product);
		return "redirect:/";
	}
	
	//show product by id and adding findcategorynotinproduct
	@GetMapping("/products/{id}")
	public String showProduct(Model model, @PathVariable("id") Long id) {
		Product product= productService.findById(id);
		model.addAttribute("allCategories", categoryService.findCategoryInProduct(product));
		model.addAttribute("product", product);
		model.addAttribute("categories", categoryService.findCategoryNotInProduct(product));
		return "showProduct.jsp";
	}
	
	//add a category to the product
			@PostMapping("/products/{id}")
			public String addCategoryToProducts(@RequestParam("addCatToProd") Long categoryId, @PathVariable("id") Long id) {
				Product product = productService.findById(id);
				Category category = categoryService.findById(categoryId);
				productService.addCategoryToProduct(category, product);
				return "redirect:/";
				
			}
	
	
	//repeat form getting info with Category model, will need to pass info through
	//Model model
	@GetMapping("/categories/new")
	public String showCategoryCreate(@ModelAttribute("category") Category category, Model model) {
		//model attribute with "categories" so that we can see locations in drop down menu
		model.addAttribute("categories", categoryService.allCategories());
		return "newCategory.jsp";
	}

	//receiving function of getmapping of categoryform
	@PostMapping("/categories")
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/";
		}
		//this prints out name of product connected to category being created
//		System.out.println(category.getProduct().getName());
		categoryService.save(category);
		return "redirect:/";
	}
	
	//show category by id
		@GetMapping("/categories/{id}")
		public String showCategory(Model model, @PathVariable("id") Long id) {
			Category category= categoryService.findById(id);
			model.addAttribute("allProducts", productService.findProductsInCategory(category));
			model.addAttribute("category", category);
			
			model.addAttribute("products", productService.findProductsNotInCategory(category));
			return "showCategory.jsp";
		}
		

		
		//add a product to the category
		@PostMapping("/categories/{id}")
		public String addProductToCategory(@RequestParam("addProductToCategory") Long productId, @PathVariable("id") Long id) {
			Category category = categoryService.findById(id);
			Product product = productService.findById(productId);
			categoryService.addProductToCategory(product, category);
			
			return "redirect:/";
			
		}
		
	

}
