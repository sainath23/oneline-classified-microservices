package com.doitgeek.oc.postmanagementservice.rest;

import com.doitgeek.oc.postmanagementservice.constant.AppConstant;
import com.doitgeek.oc.postmanagementservice.constant.MessageConstant;
import com.doitgeek.oc.postmanagementservice.entity.Post;
import com.doitgeek.oc.postmanagementservice.exception.PostNotFoundException;
import com.doitgeek.oc.postmanagementservice.model.ApiResponseModel;
import com.doitgeek.oc.postmanagementservice.model.PostModel;
import com.doitgeek.oc.postmanagementservice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostRestController {

    private PostService postService;

    @Autowired
    public PostRestController(PostService postService) {
        this.postService = postService;
    }

    // Post APIs
    // createPost
    @PostMapping
    public ResponseEntity<ApiResponseModel<Post>> createPost(@RequestBody final PostModel postModel) {
        return new ResponseEntity<>(new ApiResponseModel<>(AppConstant.SUCCESS, postService.createPost(postModel)), HttpStatus.CREATED);
    }

    // getPostById
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseModel<Post>> getPostById(@PathVariable("id") final Long id) {
        Post post = postService.findById(id).orElseThrow(() -> new PostNotFoundException(MessageConstant.POST_NOT_FOUND));
        return new ResponseEntity<>(new ApiResponseModel<>(AppConstant.SUCCESS, post), HttpStatus.OK);
    }

    // getAllPosts
    @GetMapping
    public ResponseEntity<ApiResponseModel<List<Post>>> getAllPosts() {
        return new ResponseEntity<>(new ApiResponseModel<>(AppConstant.SUCCESS, postService.findAll()), HttpStatus.OK);
    }

    // updatePostById
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseModel<Post>> updatePostById(@PathVariable("id") final Long id, @RequestBody PostModel postModel) {
        return new ResponseEntity<>(new ApiResponseModel<>(AppConstant.SUCCESS, postService.updateById(id, postModel)), HttpStatus.OK);
    }

    // deletePostById
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") final Long id) {
        postService.deleteById(id);
    }
}
