package com.exam.ms_category.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name ="category")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category  implements Serializable{

	@Id  
	@Column(name="category_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="category_name")
	private String categoryName;
	
	@Column(name="description")
	private String description;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Product> products;
	
}
