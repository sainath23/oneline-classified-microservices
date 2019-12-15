package com.doitgeek.oc.categorymanagementservice.model;

import com.doitgeek.oc.categorymanagementservice.annotation.Flag;
import com.doitgeek.oc.categorymanagementservice.constant.MessageConstant;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Map;

public class CategoryPropertyModel {

    @NotNull(message = MessageConstant.CATEGORY_ID_REQUIRED)
    private Long categoryId;

    @NotBlank(message = MessageConstant.PROPERTY_NAME_REQUIRED)
    @Size(max = 99, message = MessageConstant.PROPERTY_NAME_VALID)
    private String propertyName;

    @Size(max = 99, message = MessageConstant.PROPERTY_UNIT_VALID)
    private String propertyUnit;

    @NotNull(message = MessageConstant.IS_MANDATORY_REQUIRED)
    @Flag
    private Character isMandatory;

    private Map<String, String> possibleValues;

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
}
