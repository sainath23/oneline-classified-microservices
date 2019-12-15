package com.doitgeek.oc.categorymanagementservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category implements Serializable {

    private static final long serialVersionUID = -2439002079849270695L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "parent_category_id")
    private Long parentCategoryId;

    @Column(name = "max_images_allowed")
    private Integer maxImagesAllowed;

    @Column(name = "post_validity_days")
    private Integer postValidityDays;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private Set<CategoryProperty> categoryProperties;

    public Category() {
    }

    public Category(String categoryName, Long parentCategoryId, Integer maxImagesAllowed, Integer postValidityDays) {
        this.categoryName = categoryName;
        this.parentCategoryId = parentCategoryId;
        this.maxImagesAllowed = maxImagesAllowed;
        this.postValidityDays = postValidityDays;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Set<CategoryProperty> getCategoryProperties() {
        return categoryProperties;
    }

    public void setCategoryProperties(Set<CategoryProperty> categoryProperties) {
        this.categoryProperties = categoryProperties;
    }
}
