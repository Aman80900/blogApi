package com.spring.blog.rest.api.service.impl;

import com.spring.blog.rest.api.entity.Post;
import com.spring.blog.rest.api.repository.PostRepository;
import com.spring.blog.rest.api.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;
    @Override
    public Post createPost(Post newPost) {
        return  postRepository.save(newPost);
    }

    @Override
    public List<Post> getAllPost() {
        return postRepository.findAll();
    }

    @Override
    public Post getPostById(Long id) {
        return postRepository.findById(id).orElseThrow(() -> new RuntimeException("Resource Not Found..."));
    }

    @Override
    public Post updatePost(Long id, Post updatePost) {

        Post existingPost = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Resource Not Found..."));

        // Update the attributes of the existingPost
        existingPost.setTitle(updatePost.getTitle());
        existingPost.setDescription(updatePost.getDescription());

        // Update the comments collection
        existingPost.getComments().clear(); // Clear existing comments
        existingPost.getComments().addAll(updatePost.getComments()); // Add new comments

        // Save the updated Post entity
        return postRepository.save(existingPost);

    }

    @Override
    public void deletePost(Long id) {

        Post newPost= postRepository.findById(id).orElseThrow(() -> new RuntimeException("Resource Not Found..."));
        postRepository.deleteById(id);

    }
}
