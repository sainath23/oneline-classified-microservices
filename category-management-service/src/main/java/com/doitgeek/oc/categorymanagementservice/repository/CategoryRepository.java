package com.doitgeek.oc.categorymanagementservice.repository;

import com.doitgeek.oc.categorymanagementservice.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByCategoryName(String categoryName);
}
