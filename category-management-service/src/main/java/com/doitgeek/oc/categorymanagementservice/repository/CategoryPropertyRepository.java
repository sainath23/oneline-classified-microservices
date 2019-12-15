package com.doitgeek.oc.categorymanagementservice.repository;

import com.doitgeek.oc.categorymanagementservice.entity.CategoryProperty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryPropertyRepository extends JpaRepository<CategoryProperty, Long> {
    Optional<CategoryProperty> findByPropertyName(String propertyName);
}
