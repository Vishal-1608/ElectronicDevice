package com.exam.ms_category.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.exam.ms_category.entity.Category;


public interface CategoryService {

Category save(Category category);

Category getbyId(Long id);

Category updateCategory(Category category,Long id);

Category deleteCategory(Long id);
	
List<Category> getAllCategory();
	
List<Category> getAllPage(Integer page);
	

	

}
