package com.etna.gpe.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etna.gpe.controller.customexception.ParametersNotFound;
import com.etna.gpe.controller.customexception.ResourceNotExist;
import com.etna.gpe.dto.CategoryDto;
import com.etna.gpe.model.Category;
import com.etna.gpe.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	
	
	
	public CategoryDto addOrUpdateCategory(CategoryDto categoryDto) {
		if(categoryDto == null)
			throw new ParametersNotFound();
		
		Category category = categoryRepository.findCategoryByCategoryName(categoryDto.getCategoryName());
		if(category == null)
			category = new Category(categoryDto);
		else {
			if(category.isCategoryisDeleted())
				throw new ResourceNotExist();
			
			category.setCategoryDescription(categoryDto.getCategoryDescription());
			category.setCategoryName(categoryDto.getCategoryName());
		}
		categoryRepository.save(category);
		
		categoryDto.setCategoryId(category.getCategoryId());
		
		return categoryDto;
	}
	
	public List<CategoryDto> findCategories(String criteria){
		List<CategoryDto> resultsDto = new ArrayList<CategoryDto>();
		List<Category> allCategoris = new ArrayList<Category>();
		categoryRepository.findAll().iterator().forEachRemaining(allCategoris::add);
		try {
			int id = Integer.parseInt(criteria);
			Category categoryById = categoryRepository.findById(id).get();
			if(categoryById.isCategoryisDeleted())
				throw new ResourceNotExist();
			
			resultsDto.add(new CategoryDto(categoryById));
			
		}catch(NumberFormatException exception) {
			if(criteria == null || criteria.isEmpty())
				resultsDto = allCategoris.stream()
					.filter(c -> !c.isCategoryisDeleted())
					.map(c -> new CategoryDto(c)).collect(Collectors.toList());
			else {
				Category category = categoryRepository.findCategoryByCategoryName(criteria);
				if(category.isCategoryisDeleted())
					throw new ResourceNotExist();
				resultsDto.add(new CategoryDto(category));
				
			}
		}
		return resultsDto;
	}
	
	public boolean deleteCategory(int categoryId) {
		boolean isDeleted = false;
		if(categoryId > 0){
			Category categoryById = categoryRepository.findById(categoryId).get();
			categoryById.setCategoryisDeleted(true);
			categoryRepository.save(categoryById);
			isDeleted = true;
		}else
			throw new ResourceNotExist();
		return isDeleted;
	}
}
