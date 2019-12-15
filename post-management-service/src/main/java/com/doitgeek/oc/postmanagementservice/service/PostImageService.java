package com.doitgeek.oc.postmanagementservice.service;

import com.doitgeek.oc.postmanagementservice.entity.PostImage;

import java.util.List;
import java.util.Optional;

public interface PostImageService {
    Optional<PostImage> findById(Long id);
    List<PostImage> findAll();
    PostImage save(PostImage postImage);
    void deleteById(Long id);
}
