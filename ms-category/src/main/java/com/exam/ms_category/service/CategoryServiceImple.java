package com.exam.ms_category.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.exam.ms_category.entity.Category;
import com.exam.ms_category.entity.Product;
import com.exam.ms_category.exception.ResourceNotFoundException;
import com.exam.ms_category.repository.CategoryRepository;

@Service
public class CategoryServiceImple implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public Category save(Category category) {
		 if (category.getProducts() != null) {
		        for (Product product : category.getProducts()) {
		            product.setCategory(category);  // Set the category reference in each product
		        }
		    }

		    return categoryRepository.save(category);
	}

	@Override
	public Category getbyId(Long id) {
		return categoryRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Resource Not Found"));
	}

	@Override
	public Category updateCategory(Category category, Long id) {
		Optional<Category> opt=categoryRepository.findById(id);	
		if(opt.isPresent()){
		Category category1=opt.get();
	//	category1.setId(category.getId());
		category1.setCategoryName(category.getCategoryName());
		category1.setDescription(category.getDescription());
		category1.setProducts(category.getProducts());
		Category save=categoryRepository.save(category1);
		return save;
		}
		return getbyId(id);
		
	}

	public Category deleteCategory(Long id) {
		Category category=categoryRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Resource Not Found"));
		  categoryRepository.delete(category);
		  return category;
	}

	@Override
	public List<Category> getAllCategory() {
		return categoryRepository.findAll();
	}

	@Override
	public List<Category> getAllPage(Integer page) {
		Pageable pageable = PageRequest.of(page-1, 2);
		Page<Category> all = categoryRepository.findAll(pageable);
		return all.toList();
	}

}
