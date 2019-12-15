package com.doitgeek.oc.categorymanagementservice.service;

import com.doitgeek.oc.categorymanagementservice.constant.MessageConstant;
import com.doitgeek.oc.categorymanagementservice.entity.Category;
import com.doitgeek.oc.categorymanagementservice.exception.CategoryNotFoundException;
import com.doitgeek.oc.categorymanagementservice.model.CategoryModel;
import com.doitgeek.oc.categorymanagementservice.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Optional<Category> findByCategoryName(String categoryName) {
        return categoryRepository.findByCategoryName(categoryName);
    }

    @Override
    @Transactional
    public Category createCategory(CategoryModel categoryModel) {
        if (findByCategoryName(categoryModel.getCategoryName()).isPresent()) {
            throw new RuntimeException(MessageConstant.CATEGORY_EXIST);
        }

        Category newCategory = new Category(categoryModel.getCategoryName(),
                                            categoryModel.getParentCategoryId(),
                                            categoryModel.getMaxImagesAllowed(),
                                            categoryModel.getPostValidityDays());

        return save(newCategory);
    }

    @Override
    @Transactional
    public Category updateCategoryById(Long id, CategoryModel categoryModel) {
        Optional<Category> optionalCategory = findById(id);
        if(optionalCategory.isPresent()) {
            Category categoryToUpdate = optionalCategory.get();

            categoryToUpdate.setCategoryName(categoryModel.getCategoryName());
            categoryToUpdate.setParentCategoryId(categoryModel.getParentCategoryId());
            categoryToUpdate.setMaxImagesAllowed(categoryModel.getMaxImagesAllowed());
            categoryToUpdate.setPostValidityDays(categoryModel.getPostValidityDays());

            return save(categoryToUpdate);
        }

        throw new CategoryNotFoundException(MessageConstant.CATEGORY_NOT_FOUND);
    }
}
