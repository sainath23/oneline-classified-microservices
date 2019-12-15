package com.doitgeek.oc.categorymanagementservice.rest;

import com.doitgeek.oc.categorymanagementservice.constant.AppConstant;
import com.doitgeek.oc.categorymanagementservice.constant.MessageConstant;
import com.doitgeek.oc.categorymanagementservice.entity.Category;
import com.doitgeek.oc.categorymanagementservice.entity.CategoryProperty;
import com.doitgeek.oc.categorymanagementservice.exception.CategoryNotFoundException;
import com.doitgeek.oc.categorymanagementservice.model.ApiResponseModel;
import com.doitgeek.oc.categorymanagementservice.model.CategoryModel;
import com.doitgeek.oc.categorymanagementservice.model.CategoryPropertyModel;
import com.doitgeek.oc.categorymanagementservice.service.CategoryPropertyService;
import com.doitgeek.oc.categorymanagementservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryRestController {

    private CategoryService categoryService;
    private CategoryPropertyService categoryPropertyService;

    @Autowired
    public CategoryRestController(CategoryService categoryService, CategoryPropertyService categoryPropertyService) {
        this.categoryService = categoryService;
        this.categoryPropertyService = categoryPropertyService;
    }

    @PostMapping
    public ResponseEntity<ApiResponseModel<Category>> createCategory(@Valid @RequestBody final CategoryModel categoryModel) {
        return new ResponseEntity<>(new ApiResponseModel<>(AppConstant.SUCCESS, categoryService.createCategory(categoryModel)), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseModel<Category>> getCategoryById(@PathVariable("id") final Long id) {
        Category category = categoryService.findById(id).orElseThrow(() -> new CategoryNotFoundException(MessageConstant.CATEGORY_NOT_FOUND));
        return new ResponseEntity<>(new ApiResponseModel<>(AppConstant.SUCCESS, category), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ApiResponseModel<List<Category>>> getAllCategories() {
        return new ResponseEntity<>(new ApiResponseModel<>(AppConstant.SUCCESS, categoryService.findAll()), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseModel<Category>> updateCategoryById(@Valid @RequestBody final CategoryModel categoryModel,
                                                                         @PathVariable("id") final Long id) {
        return new ResponseEntity<>(new ApiResponseModel<>(AppConstant.SUCCESS, categoryService.updateCategoryById(id, categoryModel)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteCategoryById(@PathVariable("id") final Long id) {
        categoryService.deleteById(id);
    }

    // Category property APIs

    @PostMapping("/property")
    public ResponseEntity<ApiResponseModel<CategoryProperty>> createCategoryProperty(@Valid @RequestBody final CategoryPropertyModel categoryPropertyModel) {
        return new ResponseEntity<>(new ApiResponseModel<>(AppConstant.SUCCESS, categoryPropertyService.createCategoryProperty(categoryPropertyModel)),
                                    HttpStatus.CREATED);
    }

    @GetMapping("/property/{id}")
    public ResponseEntity<ApiResponseModel<CategoryProperty>> getCategoryPropertyById(@PathVariable("id") final Long id) {
        CategoryProperty categoryProperty = categoryPropertyService.findById(id).orElseThrow(() -> new RuntimeException(MessageConstant.CATEGORY_PROPERTY_NOT_FOUND));
        return new ResponseEntity<>(new ApiResponseModel<>(AppConstant.SUCCESS, categoryProperty), HttpStatus.OK);
    }

    @GetMapping("/property")
    public ResponseEntity<ApiResponseModel<List<CategoryProperty>>> getAllCategoryProperties() {
        return new ResponseEntity<>(new ApiResponseModel<>(AppConstant.SUCCESS, categoryPropertyService.findAll()), HttpStatus.OK);
    }

    @PutMapping("/property/{id}")
    public ResponseEntity<ApiResponseModel<CategoryProperty>> updateCategoryPropertyById(@Valid @RequestBody final CategoryPropertyModel categoryPropertyModel,
                                                                                         @PathVariable("id") final Long id) {
        return new ResponseEntity<>(new ApiResponseModel<>(AppConstant.SUCCESS, categoryPropertyService.updateCategoryPropertyById(id, categoryPropertyModel)),
                                    HttpStatus.OK);
    }

    @DeleteMapping("/property/{id}")
    public void deleteCategoryPropertyById(@PathVariable("id") final Long id) {
        categoryPropertyService.deleteById(id);
    }
}
