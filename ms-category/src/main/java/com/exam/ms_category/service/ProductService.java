package com.exam.ms_category.service;

import java.util.List;
import java.util.Locale.Category;

import com.exam.ms_category.entity.Product;

public interface ProductService {

	Product save(Product Product);

	Product getbyId(Long id);

	Product updateProduct(Product product,Long id);

	Product deleteProduct(Long id);
		
	List<Product> getAllProduct();
	
	List<Product> getAllPage(Integer page);
		
}
