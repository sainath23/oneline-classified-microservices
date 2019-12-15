package com.doitgeek.oc.postmanagementservice.service;

import com.doitgeek.oc.postmanagementservice.entity.Post;
import com.doitgeek.oc.postmanagementservice.model.PostModel;

import java.util.List;
import java.util.Optional;

public interface PostService {
    Optional<Post> findById(Long id);
    List<Post> findAll();
    Post save(Post post);
    void deleteById(Long id);
    Post createPost(PostModel postModel);
    Post updateById(Long id, PostModel postModel);
    Post deactivatePostById(Long id);
    Post renewPostById(Long id);
}
