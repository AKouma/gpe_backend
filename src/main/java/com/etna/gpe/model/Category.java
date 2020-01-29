package com.etna.gpe.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "category_id") 
	int categoryId;
	
	@NotBlank
	@Column(name ="category_description")
	String categoryDescription;
	
	@Column(name ="category_create_date")
	String categoryCreateDate;
	
	@Column(name ="category_update_date")
	String categoryUpdateDate;
	
	@Column(name ="category_delete_date")
	String categoryDeleteDate;
	
	@Column(name ="category_is_deleted")
	boolean categoryisDeleted;
	
	@NotBlank
	@Column(name ="category_name")
	String categoryName;

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

	public String getCategoryCreateDate() {
		return categoryCreateDate;
	}

	public void setCategoryCreateDate(String categoryCreateDate) {
		this.categoryCreateDate = categoryCreateDate;
	}

	public String getCategoryUpdateDate() {
		return categoryUpdateDate;
	}

	public void setCategoryUpdateDate(String categoryUpdateDate) {
		this.categoryUpdateDate = categoryUpdateDate;
	}

	public String getCategoryDeleteDate() {
		return categoryDeleteDate;
	}

	public void setCategoryDeleteDate(String categoryDeleteDate) {
		this.categoryDeleteDate = categoryDeleteDate;
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
