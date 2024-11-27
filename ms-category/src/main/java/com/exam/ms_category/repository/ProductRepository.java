package com.exam.ms_category.repository;

import java.util.Locale.Category;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.ms_category.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
