package com.doitgeek.oc.postmanagementservice.service;

import com.doitgeek.oc.postmanagementservice.constant.AppConstant;
import com.doitgeek.oc.postmanagementservice.constant.MessageConstant;
import com.doitgeek.oc.postmanagementservice.entity.Post;
import com.doitgeek.oc.postmanagementservice.entity.PostAttribute;
import com.doitgeek.oc.postmanagementservice.exception.PostNotFoundException;
import com.doitgeek.oc.postmanagementservice.model.PostModel;
import com.doitgeek.oc.postmanagementservice.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    private PostAttributeService postAttributeService;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, PostAttributeService postAttributeService) {
        this.postRepository = postRepository;
        this.postAttributeService = postAttributeService;
    }

    @Override
    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Post createPost(PostModel postModel) {
        Post newPost = postModel.getPost();
        newPost = save(newPost);

        PostAttribute newPostAttribute = new PostAttribute(newPost.getId(), postModel.getPostAttributes());
        postAttributeService.save(newPostAttribute);

        return newPost;
    }

    @Transactional
    @Override
    public Post updateById(Long id, PostModel postModel) {
        Post postToUpdate = isPostPresent(id);
        postToUpdate.setCategoryId(postModel.getCategoryId());
        postToUpdate.setPostTitle(postModel.getPostTitle());
        postToUpdate.setPostDetail(postModel.getPostDetail());
        postToUpdate.setIsIndividual(postModel.getIsIndividual());
        postToUpdate.setExpectedPrice(postModel.getExpectedPrice());
        postToUpdate.setIsPriceNegotiable(postModel.getIsPriceNegotiable());
        postToUpdate.setLocation(postModel.getLocation());

        return save(postToUpdate);
    }

    @Transactional
    @Override
    public Post deactivatePostById(Long id) {
        Post postToDeactivate = isPostPresent(id);
        postToDeactivate.setIsActive(AppConstant.NO);
        return save(postToDeactivate);
    }

    @Transactional
    @Override
    public Post renewPostById(Long id) {
        Post postToRenew = isPostPresent(id);
        postToRenew.setIsActive(AppConstant.YES);
        postToRenew.setLastRenewedOn(new Date());
        return save(postToRenew);
    }

    // private helper methods
    private Post isPostPresent(Long id) {
        Optional<Post> optionalPost = findById(id);
        return optionalPost.orElseThrow(() -> new PostNotFoundException(MessageConstant.POST_NOT_FOUND));
    }
}
