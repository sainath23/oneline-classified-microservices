package com.doitgeek.oc.categorymanagementservice.service;

import com.doitgeek.oc.categorymanagementservice.constant.MessageConstant;
import com.doitgeek.oc.categorymanagementservice.entity.Category;
import com.doitgeek.oc.categorymanagementservice.entity.CategoryProperty;
import com.doitgeek.oc.categorymanagementservice.model.CategoryPropertyModel;
import com.doitgeek.oc.categorymanagementservice.repository.CategoryPropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryPropertyServiceImpl implements CategoryPropertyService {

    private CategoryPropertyRepository categoryPropertyRepository;

    @Autowired
    public CategoryPropertyServiceImpl(CategoryPropertyRepository categoryPropertyRepository) {
        this.categoryPropertyRepository = categoryPropertyRepository;
    }

    @Override
    public Optional<CategoryProperty> findById(Long id) {
        return categoryPropertyRepository.findById(id);
    }

    @Override
    public List<CategoryProperty> findAll() {
        return categoryPropertyRepository.findAll();
    }

    @Override
    public CategoryProperty save(CategoryProperty categoryProperty) {
        return categoryPropertyRepository.save(categoryProperty);
    }

    @Override
    public void deleteById(Long id) {
        categoryPropertyRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CategoryProperty> findByPropertyName(String propertyName) {
        return categoryPropertyRepository.findByPropertyName(propertyName);
    }

    @Override
    @Transactional
    public CategoryProperty createCategoryProperty(CategoryPropertyModel categoryPropertyModel) {
        if (findByPropertyName(categoryPropertyModel.getPropertyName()).isPresent()) {
            throw new RuntimeException(MessageConstant.CATEGORY_PROPERTY_EXIST);
        }
        CategoryProperty newCategoryProperty = new CategoryProperty(categoryPropertyModel.getCategoryId(),
                                                                    categoryPropertyModel.getPropertyName(),
                                                                    categoryPropertyModel.getPropertyUnit(),
                                                                    categoryPropertyModel.getIsMandatory(),
                                                                    categoryPropertyModel.getPossibleValues());
        return save(newCategoryProperty);
    }

    @Override
    @Transactional
    public CategoryProperty updateCategoryPropertyById(Long id, CategoryPropertyModel categoryPropertyModel) {
        Optional<CategoryProperty> optionalCategoryProperty = findById(id);
        if (optionalCategoryProperty.isPresent()) {
            CategoryProperty categoryPropertyToUpdate = optionalCategoryProperty.get();

            categoryPropertyToUpdate.setCategoryId(categoryPropertyModel.getCategoryId());
            categoryPropertyToUpdate.setPropertyName(categoryPropertyModel.getPropertyName());
            categoryPropertyToUpdate.setPropertyUnit(categoryPropertyModel.getPropertyUnit());
            categoryPropertyToUpdate.setIsMandatory(categoryPropertyModel.getIsMandatory());
            categoryPropertyToUpdate.setPossibleValues(categoryPropertyModel.getPossibleValues());

            return save(categoryPropertyToUpdate);
        }

        throw new RuntimeException(MessageConstant.CATEGORY_PROPERTY_NOT_FOUND);
    }

}
