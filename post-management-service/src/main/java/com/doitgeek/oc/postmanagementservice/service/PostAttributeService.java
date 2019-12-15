package com.doitgeek.oc.postmanagementservice.service;

import com.doitgeek.oc.postmanagementservice.entity.PostAttribute;

import java.util.List;
import java.util.Optional;

public interface PostAttributeService {
    Optional<PostAttribute> findById(Long id);
    List<PostAttribute> findAll();
    PostAttribute save(PostAttribute postAttribute);
    void deleteById(Long id);
}
