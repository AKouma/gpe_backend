package com.etna.gpe.model;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.etna.gpe.dto.CategoryDto;

@Entity
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "category_id")
	int categoryId;

	@Column(name = "category_description", nullable = false)
	String categoryDescription;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "category_create_date")
	Date categoryCreateDate;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "category_update_date")
	Date categoryUpdateDate;

	@Column(name = "category_is_deleted")
	boolean categoryisDeleted;

	@Column(name = "category_name", nullable = false)
	String categoryName;
	
	public Category() {}

	public Category(CategoryDto categoryDto) {
		if (categoryDto.getCategoryId() > 0)
			this.setCategoryId(categoryDto.getCategoryId());
		this.setCategoryDescription(categoryDto.getCategoryDescription());
		this.setCategoryName(categoryDto.getCategoryName());
		this.setCategoryCreateDate(categoryDto.getCategoryCreateDate());
		this.setCategoryUpdateDate(categoryDto.getCategoryUpdateDate());
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryDescription=" + categoryDescription
				+ ", categoryCreateDate=" + categoryCreateDate + ", categoryUpdateDate=" + categoryUpdateDate
				+ ", categoryisDeleted=" + categoryisDeleted + ", categoryName=" + categoryName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoryCreateDate == null) ? 0 : categoryCreateDate.hashCode());
		result = prime * result + ((categoryDescription == null) ? 0 : categoryDescription.hashCode());
		result = prime * result + categoryId;
		result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
		result = prime * result + ((categoryUpdateDate == null) ? 0 : categoryUpdateDate.hashCode());
		result = prime * result + (categoryisDeleted ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (categoryCreateDate == null) {
			if (other.categoryCreateDate != null)
				return false;
		} else if (!categoryCreateDate.equals(other.categoryCreateDate))
			return false;
		if (categoryDescription == null) {
			if (other.categoryDescription != null)
				return false;
		} else if (!categoryDescription.equals(other.categoryDescription))
			return false;
		if (categoryId != other.categoryId)
			return false;
		if (categoryName == null) {
			if (other.categoryName != null)
				return false;
		} else if (!categoryName.equals(other.categoryName))
			return false;
		if (categoryUpdateDate == null) {
			if (other.categoryUpdateDate != null)
				return false;
		} else if (!categoryUpdateDate.equals(other.categoryUpdateDate))
			return false;
		if (categoryisDeleted != other.categoryisDeleted)
			return false;
		return true;
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
