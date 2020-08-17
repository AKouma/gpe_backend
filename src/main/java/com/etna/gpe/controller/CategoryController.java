package com.etna.gpe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.etna.gpe.dto.CategoryDto;
import com.etna.gpe.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	
	@Autowired
	CategoryService categoryService;
	
	
	@PostMapping("/add_update_category")
	@ResponseStatus(HttpStatus.CREATED)
	public CategoryDto addOrUpdateCategory(@RequestBody CategoryDto categoryDto) {
		return categoryService.addOrUpdateCategory(categoryDto);
	}
	

	@GetMapping("/search_category")
	@ResponseStatus(HttpStatus.OK)
	public List<CategoryDto> findCategory(@RequestParam String criteria) {
		return categoryService.findCategories(criteria);
	}
	
	@GetMapping("/delete_category")
	@ResponseStatus(HttpStatus.RESET_CONTENT)
	public boolean findCategory(@RequestParam int id) {
		return categoryService.deleteCategory(id);
	}
}
