package com.doitgeek.oc.postmanagementservice.repository;

import com.doitgeek.oc.postmanagementservice.entity.PostAttribute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostAttributeRepository extends JpaRepository<PostAttribute, Long> {
}
