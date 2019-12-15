package com.doitgeek.oc.categorymanagementservice.service;

import com.doitgeek.oc.categorymanagementservice.entity.Category;
import com.doitgeek.oc.categorymanagementservice.model.CategoryModel;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    Optional<Category> findById(Long id);
    List<Category> findAll();
    Category save(Category category);
    void deleteById(Long id);
    Optional<Category> findByCategoryName(String categoryName);
    Category createCategory(CategoryModel categoryModel);
    Category updateCategoryById(Long id, CategoryModel categoryModel);
}
