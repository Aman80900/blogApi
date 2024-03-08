package com.spring.blog.rest.api.controller;

import com.spring.blog.rest.api.entity.Post;
import com.spring.blog.rest.api.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/blog")
@RestController
public class PostMainController {

    @Autowired
    private PostService postService;

    @GetMapping
    public List<Post> getPost()
    {
        return postService.getAllPost();
    }
    @PostMapping
    public Post createPost(@RequestBody Post post)
    {
        return postService.createPost(post);
    }


    @GetMapping("/{id}")
    public Post getPostById(@PathVariable("id") long id)
    {
        return postService.getPostById(id);
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable("id") long id,
                           @RequestBody Post post)
    {
        return postService.updatePost(id,post);
    }

    @DeleteMapping({"/{id}"})
    public String  deletePost(@PathVariable("id") long id )
    {
        postService.deletePost(id);

        return "Post deleted for id: "+ id;

    }
}
