package com.example.webservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.webservice.model.Comment;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {
}
