package com.sgu.j2watch.services;

import org.springframework.stereotype.Service;

import com.sgu.j2watch.entities.Category;

@Service
public interface CategoryService {

	Object getAllCategories();

	Category getCategoryById(Integer id_category);

	void saveCategory(Category category);

	void deleteCategory(Integer id_category);

}
