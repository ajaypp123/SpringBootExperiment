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

import com.example.webservice.model.Comment;
import com.example.webservice.repo.CommentRepo;

@RestController
@RequestMapping("/v1/api/comments")
public class CommentController {
    @Autowired
    private CommentRepo commentRepo;

    @PostMapping
    public Comment createComment(@RequestBody Comment comment) {
        return commentRepo.save(comment);
    }

    @GetMapping("/{id}")
    public Comment getComment(@PathVariable Long id) {
        return commentRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Comment not found with id: " + id));
    }

    @PutMapping("/{id}")
    public Comment updateComment(@PathVariable Long id, @RequestBody Comment updatedComment) {
        Comment comment = commentRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Comment not found with id: " + id));

        comment.setText(updatedComment.getText());
        comment.setUser(updatedComment.getUser());
        comment.setPost(updatedComment.getPost());

        return commentRepo.save(comment);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Long id) {
        Comment comment = commentRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Comment not found with id: " + id));

        commentRepo.delete(comment);
    }
}
