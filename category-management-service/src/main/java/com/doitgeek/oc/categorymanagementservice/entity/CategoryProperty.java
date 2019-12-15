package com.doitgeek.oc.categorymanagementservice.entity;

import com.doitgeek.oc.categorymanagementservice.util.StringMapConverter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Map;

@Entity
@Table(name = "category_property")
public class CategoryProperty implements Serializable {

    private static final long serialVersionUID = -4297813544354720409L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "property_name")
    private String propertyName;

    @Column(name = "property_unit")
    private String propertyUnit;

    @Column(name = "is_mandatory")
    private Character isMandatory;

    @Column(name = "possible_values")
    @Convert(converter = StringMapConverter.class)
    private Map<String, String> possibleValues;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    private Category category;

    public CategoryProperty() {
    }

    public CategoryProperty(Long categoryId, String propertyName, String propertyUnit, Character isMandatory, Map<String, String> possibleValues) {
        this.categoryId = categoryId;
        this.propertyName = propertyName;
        this.propertyUnit = propertyUnit;
        this.isMandatory = isMandatory;
        this.possibleValues = possibleValues;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyUnit() {
        return propertyUnit;
    }

    public void setPropertyUnit(String propertyUnit) {
        this.propertyUnit = propertyUnit;
    }

    public Character getIsMandatory() {
        return isMandatory;
    }

    public void setIsMandatory(Character isMandatory) {
        this.isMandatory = isMandatory;
    }

    public Map<String, String> getPossibleValues() {
        return possibleValues;
    }

    public void setPossibleValues(Map<String, String> possibleValues) {
        this.possibleValues = possibleValues;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
