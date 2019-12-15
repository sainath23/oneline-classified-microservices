package com.doitgeek.oc.categorymanagementservice.model;

import com.doitgeek.oc.categorymanagementservice.constant.MessageConstant;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CategoryModel {

    @NotBlank(message = MessageConstant.CATEGORY_NAME_REQUIRED)
    @Size(max = 99, message = MessageConstant.CATEGORY_NAME_VALID)
    private String categoryName;

    private Long parentCategoryId;

    @NotNull(message = MessageConstant.MAX_IMAGES_ALLOWED_REQUIRED)
    private Integer maxImagesAllowed;

    @NotNull(message = MessageConstant.POST_VALIDITY_DAYS_REQUIRED)
    private Integer postValidityDays;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Long getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(Long parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    public Integer getMaxImagesAllowed() {
        return maxImagesAllowed;
    }

    public void setMaxImagesAllowed(Integer maxImagesAllowed) {
        this.maxImagesAllowed = maxImagesAllowed;
    }

    public Integer getPostValidityDays() {
        return postValidityDays;
    }

    public void setPostValidityDays(Integer postValidityDays) {
        this.postValidityDays = postValidityDays;
    }
}
