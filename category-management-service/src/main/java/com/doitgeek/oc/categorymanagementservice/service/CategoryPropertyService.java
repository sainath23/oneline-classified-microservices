package com.doitgeek.oc.categorymanagementservice.service;

import com.doitgeek.oc.categorymanagementservice.entity.CategoryProperty;
import com.doitgeek.oc.categorymanagementservice.model.CategoryPropertyModel;

import java.util.List;
import java.util.Optional;

public interface CategoryPropertyService {
    Optional<CategoryProperty> findById(Long id);
    List<CategoryProperty> findAll();
    CategoryProperty save(CategoryProperty categoryProperty);
    void deleteById(Long id);
    Optional<CategoryProperty> findByPropertyName(String propertyName);
    CategoryProperty createCategoryProperty(CategoryPropertyModel categoryPropertyModel);
    CategoryProperty updateCategoryPropertyById(Long id, CategoryPropertyModel categoryPropertyModel);
}
