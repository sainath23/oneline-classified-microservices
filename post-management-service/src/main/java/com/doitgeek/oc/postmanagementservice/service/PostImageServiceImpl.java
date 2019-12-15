package com.doitgeek.oc.postmanagementservice.service;

import com.doitgeek.oc.postmanagementservice.entity.PostImage;
import com.doitgeek.oc.postmanagementservice.repository.PostImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostImageServiceImpl implements PostImageService {

    private PostImageRepository postImageRepository;

    @Autowired
    public PostImageServiceImpl(PostImageRepository postImageRepository) {
        this.postImageRepository = postImageRepository;
    }

    @Override
    public Optional<PostImage> findById(Long id) {
        return postImageRepository.findById(id);
    }

    @Override
    public List<PostImage> findAll() {
        return postImageRepository.findAll();
    }

    @Override
    public PostImage save(PostImage postImage) {
        return postImageRepository.save(postImage);
    }

    @Override
    public void deleteById(Long id) {
        postImageRepository.deleteById(id);
    }
}
