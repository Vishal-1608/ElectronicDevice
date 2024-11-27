package com.exam.ms_category.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.ms_category.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Long>{

}
