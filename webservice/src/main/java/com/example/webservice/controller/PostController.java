package com.example.webservice.controller;

import javax.ws.rs.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.webservice.model.Post;
import com.example.webservice.repo.PostRepo;

@RestController
@RequestMapping("/v1/api/posts")
public class PostController {

    @Autowired
    private PostRepo postRepo;

    // Create Post
    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postRepo.save(post);
    }

    // Get Post by ID
    @GetMapping("/{id}")
    public Post getPost(@PathVariable Long id) {
        return postRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Post not found with id: " + id));
    }

    // Update Post
    @PutMapping("/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody Post updatedPost) {
        Post post = postRepo.findById(id)
            .orElseThrow(() -> new NotFoundException("Post not found with id: " + id));

        post.setTitle(updatedPost.getTitle());
        post.setContent(updatedPost.getContent());
        post.setUser(updatedPost.getUser());

        return postRepo.save(post);
    }

    // Delete Post
    @DeleteMapping("{id}")
    public void deletePost(@PathVariable Long id) {
        Post post = postRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Post not found with id: " + id));

        postRepo.delete(post);
    }
}
