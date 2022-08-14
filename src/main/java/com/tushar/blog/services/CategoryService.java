package com.tushar.blog.services;

import java.util.List;

import com.tushar.blog.payloads.CategoryDto;

public interface CategoryService {
	
	// create
	CategoryDto createCategory(CategoryDto categoryDto);
	
	// update
	CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
	
	// delete
	void deleteCategory(Integer categoryId);
	
	// get all
	List<CategoryDto> getAllCategory();
	
	// get single
	CategoryDto getCategoryById(Integer categoryId);

}
