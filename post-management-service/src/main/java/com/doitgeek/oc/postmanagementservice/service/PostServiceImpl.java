package com.doitgeek.oc.postmanagementservice.service;

import com.doitgeek.oc.postmanagementservice.constant.MessageConstant;
import com.doitgeek.oc.postmanagementservice.entity.Post;
import com.doitgeek.oc.postmanagementservice.entity.PostAttribute;
import com.doitgeek.oc.postmanagementservice.exception.PostNotFoundException;
import com.doitgeek.oc.postmanagementservice.model.PostModel;
import com.doitgeek.oc.postmanagementservice.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
        Optional<Post> optionalPost = findById(id);
        if (optionalPost.isPresent()) {
            Post postToUpdate = optionalPost.get();
            postToUpdate.setCategoryId(postModel.getCategoryId());
            postToUpdate.setPostTitle(postModel.getPostTitle());
            postToUpdate.setPostDetail(postModel.getPostDetail());
            postToUpdate.setIsIndividual(postModel.getIsIndividual());
            postToUpdate.setExpectedPrice(postModel.getExpectedPrice());
            postToUpdate.setIsPriceNegotiable(postModel.getIsPriceNegotiable());
            postToUpdate.setLocation(postModel.getLocation());

            return save(postToUpdate);
        }
        throw new PostNotFoundException(MessageConstant.POST_NOT_FOUND);
    }
}
