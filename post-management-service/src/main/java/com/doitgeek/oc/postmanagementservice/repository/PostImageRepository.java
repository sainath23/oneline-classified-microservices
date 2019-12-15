package com.doitgeek.oc.postmanagementservice.repository;

import com.doitgeek.oc.postmanagementservice.entity.PostImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostImageRepository extends JpaRepository<PostImage, Long> {
}
