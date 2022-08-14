package com.tushar.blog.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tushar.blog.payloads.ApiResponse;
import com.tushar.blog.payloads.CategoryDto;
import com.tushar.blog.services.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	// create
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto) {
		CategoryDto createdCategory = this.categoryService.createCategory(categoryDto);
		return new ResponseEntity<CategoryDto>(createdCategory, HttpStatus.CREATED);
	}
	
	// update
	@PutMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable Integer categoryId) {
		CategoryDto updatedCategory = this.categoryService.updateCategory(categoryDto, categoryId);
		return new ResponseEntity<CategoryDto>(updatedCategory, HttpStatus.OK);
	}
	
	// delete
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer categoryId) {
		this.categoryService.deleteCategory(categoryId);
		ApiResponse response = new ApiResponse("Category is deleted successfully.", true);
		return ResponseEntity.ok(response);
	}
	
	// get all
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllCategory() {
		List<CategoryDto> allCategory = this.categoryService.getAllCategory();
		return ResponseEntity.ok(allCategory);
	}
	
	// get single
	@GetMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Integer categoryId) {
		CategoryDto categoryDto = this.categoryService.getCategoryById(categoryId);
		return ResponseEntity.ok(categoryDto);
	}
	
}
