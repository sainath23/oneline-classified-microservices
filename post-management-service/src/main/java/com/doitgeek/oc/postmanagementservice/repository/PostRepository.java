package com.doitgeek.oc.postmanagementservice.repository;

import com.doitgeek.oc.postmanagementservice.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
