package com.exam.ms_category.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exam.ms_category.entity.Category;
import com.exam.ms_category.entity.Product;
import com.exam.ms_category.repository.ProductRepository;
import com.exam.ms_category.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/save")
	public Product postMethodName(@RequestBody Product product) {
		return productService.save(product);
	}
	
	@GetMapping("/get")
	public Product getName(@RequestParam Long id) {
		return productService.getbyId(id);
	}
	
	@PatchMapping("/update")
	public Product updateMethodName(@RequestBody Product product,@RequestParam Long id) {
		return productService.updateProduct(product, id);
	}
	
	@DeleteMapping("/delete")
	public Product DeleteName(@RequestParam Long id) {
		return productService.deleteProduct(id);
	}
	
	@GetMapping("/findAll")
	public List<Product> getMethodName() {
		return productService.getAllProduct();
	}
	
	@GetMapping("/page")
	public List<Product> getMethodName(@RequestParam Integer page) {
		return productService.getAllPage(page);
	}
	
	
}
