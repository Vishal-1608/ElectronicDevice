package com.exam.ms_category.controller;

import org.springframework.web.bind.annotation.RestController;

import com.exam.ms_category.entity.Category;
import com.exam.ms_category.service.CategoryService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/save")
	public Category postMethodName(@RequestBody Category category) {
		return categoryService.save(category);
	}
	
	@GetMapping("/get")
	public Category getName(@RequestParam Long id) {
		return categoryService.getbyId(id);
	}
	
	@PatchMapping("/update")
	public Category updateMethodName(@RequestBody Category category,@RequestParam Long id) {
		return categoryService.updateCategory(category,id);
	}
	
	@DeleteMapping("/delete")
	public Category DeleteName(@RequestParam Long id) {
		return categoryService.deleteCategory(id);
	}
	
	@GetMapping("/findAll")
	public List<Category> getMethodName() {
		return categoryService.getAllCategory();
	}
	
	@GetMapping("/page")
	public List<Category> getMethodName(@RequestParam Integer page) {
		return categoryService.getAllPage(page);
	}
	
	
	
}
