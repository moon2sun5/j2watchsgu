package com.sgu.j2watch.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgu.j2watch.entities.Category;
import com.sgu.j2watch.repositories.CategoryRepository;
import com.sgu.j2watch.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository CategoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return (List<Category>) CategoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Integer id_category) {
        return CategoryRepository.findById(id_category).orElse(null);
    }

    @Override
    public void saveCategory(Category category) {
        CategoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Integer id_category) {
        CategoryRepository.deleteById(id_category);
    }
}
