package com.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.exam.Category;
import com.exam.services.CategoryService;



@RestController
@CrossOrigin("*")
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/")
	public ResponseEntity<Category> addCategory(@RequestBody Category category){
		
		Category category1=this.categoryService.addCategory(category);
		
		return ResponseEntity.ok(category1);
	}
	
	
	@GetMapping("/{categoryId}")
	public Category getCategory(@PathVariable Long categoryId){
		
		Category category=this.categoryService.getCategory(categoryId);
		return category;
	}
	
	
	
	@GetMapping("/")
	public ResponseEntity<?> getCategories(){
		
		
		return ResponseEntity.ok(this.categoryService.getCategories());
	}
	
	
	@PutMapping("/")
	public ResponseEntity<Category> updateCategory(@RequestBody Category category){
		
		Category category1=this.categoryService.addCategory(category);
		
		return ResponseEntity.ok(category1);
	}
	
	
	@DeleteMapping("/{categoryId}")
	public void deleteCategory(@PathVariable Long categoryId){
		
		//Category category=this.categoryService.getCategory(categoryId);
		//return category;
		this.categoryService.deleteCategory(categoryId);
	}
	
	
	
	

}
