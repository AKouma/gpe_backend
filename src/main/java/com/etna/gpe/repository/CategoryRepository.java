package com.etna.gpe.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.etna.gpe.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

	@Query("select c from Category c where c.categoryName =:categoryName")
	Category findCategoryByCategoryName(String categoryName);
}
