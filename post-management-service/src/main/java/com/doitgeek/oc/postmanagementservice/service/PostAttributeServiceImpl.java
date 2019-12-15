package com.doitgeek.oc.postmanagementservice.service;

import com.doitgeek.oc.postmanagementservice.entity.PostAttribute;
import com.doitgeek.oc.postmanagementservice.repository.PostAttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostAttributeServiceImpl implements PostAttributeService {

    private PostAttributeRepository postAttributeRepository;

    @Autowired
    public PostAttributeServiceImpl(PostAttributeRepository postAttributeRepository) {
        this.postAttributeRepository = postAttributeRepository;
    }

    @Override
    public Optional<PostAttribute> findById(Long id) {
        return postAttributeRepository.findById(id);
    }

    @Override
    public List<PostAttribute> findAll() {
        return postAttributeRepository.findAll();
    }

    @Override
    public PostAttribute save(PostAttribute postAttribute) {
        return postAttributeRepository.save(postAttribute);
    }

    @Override
    public void deleteById(Long id) {
        postAttributeRepository.deleteById(id);
    }
}
