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
import com.exam.ms_category.repository.ProductRepository;
import com.exam.ms_category.repository.CategoryRepository;

@Service
public class ProductServiceImple implements ProductService {

    @Autowired
    private ProductRepository productRepository;

	@Override
	public Product save(Product product) {
//		 if (product.getCategory() != null) {
//		      Category category=product.getCategory();
//		      product.setCategory(category);  // Set the category reference in each product
//		    }

		    return productRepository.save(product);
	}

	@Override
	public Product getbyId(Long id) {
		return productRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Resource Not Found"));
		}

	@Override
	public Product updateProduct(Product product, Long id) {
		Optional<Product> opt=productRepository.findById(id);	
		if(opt.isPresent()){
			Product product1=opt.get();
	//	category1.setId(category.getId());
			product1.setProductName(product.getProductName());
			product1.setPrice(product.getPrice());
			product1.setCategory(product.getCategory());
			Product save=productRepository.save(product1);
		return save;
		}
		return getbyId(id);
		
	}

	@Override
	public Product deleteProduct(Long id) {
		Product product=productRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Resource Not Found"));
		productRepository.delete(product);
		  return product;
	}

	@Override
	public List<Product> getAllProduct() {
		return productRepository.findAll();
		}

	@Override
	public List<Product> getAllPage(Integer page) {
		Pageable pageable = PageRequest.of(page-1, 2);
		Page<Product> all = productRepository.findAll(pageable);
		return all.toList();
	}

    
}
