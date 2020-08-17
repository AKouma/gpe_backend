package com.etna.gpe.dto;

import java.util.Date;

import com.etna.gpe.model.Category;

public class CategoryDto {
	int categoryId = 0;
	String categoryDescription;
	Date categoryCreateDate;
	Date categoryUpdateDate;
	boolean categoryisDeleted;
	String categoryName;

	public CategoryDto(Category category) {
		if (category.getCategoryId() > 0)
			this.setCategoryId(category.getCategoryId());
		this.setCategoryDescription(category.getCategoryDescription());
		this.setCategoryName(category.getCategoryName());
		this.setCategoryCreateDate(category.getCategoryCreateDate());
		this.setCategoryUpdateDate(category.getCategoryUpdateDate());
	}

	public CategoryDto() {
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public Date getCategoryCreateDate() {
		return categoryCreateDate;
	}

	public void setCategoryCreateDate(Date categoryCreateDate) {
		this.categoryCreateDate = categoryCreateDate;
	}

	public Date getCategoryUpdateDate() {
		return categoryUpdateDate;
	}

	public void setCategoryUpdateDate(Date categoryUpdateDate) {
		this.categoryUpdateDate = categoryUpdateDate;
	}

	public boolean isCategoryisDeleted() {
		return categoryisDeleted;
	}

	public void setCategoryisDeleted(boolean categoryisDeleted) {
		this.categoryisDeleted = categoryisDeleted;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
