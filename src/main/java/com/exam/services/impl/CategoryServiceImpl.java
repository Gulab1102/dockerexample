package com.exam.services.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.model.exam.Category;
import com.exam.repo.CategoryRepo;
import com.exam.services.CategoryService;



@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public Category addCategory(Category category) {
		// TODO Auto-generated method stub
		return this.categoryRepo.save(category);
	}

	@Override
	public Category update(Category category) {
		
		return this.categoryRepo.save(category);
	}

	@Override
	public Set<Category> getCategories() {
		
		return new LinkedHashSet<Category>(this.categoryRepo.findAll());
	}

	@Override
	public Category getCategory(Long cId) {
		
		return this.categoryRepo.findById(cId).get();
	}

	@Override
	public void deleteCategory(Long cId) {
		// TODO Auto-generated method stub
		this.categoryRepo.deleteById(cId);
		
	}

	



}
