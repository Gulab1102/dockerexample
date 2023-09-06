package com.exam.services;


import java.util.Set;

import com.exam.model.exam.Category;

public interface CategoryService {
	
	public  Category addCategory(Category category);
	
	public  Category update(Category category);
	
	public  Set<Category> getCategories();
	
	public  Category getCategory(Long cId);
	
	public  void deleteCategory(Long cId);
	

}
