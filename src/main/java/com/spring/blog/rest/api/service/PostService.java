package com.spring.blog.rest.api.service;

import com.spring.blog.rest.api.entity.Post;

import java.util.List;

public interface PostService {

    Post createPost(Post newPost);
    List<Post> getAllPost();
    Post getPostById(Long id);
    Post updatePost(Long id,Post updatePost );
    void deletePost(Long id);
}
