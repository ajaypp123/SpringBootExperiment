package com.example.webservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.webservice.model.Post;

@Repository
public interface PostRepo extends JpaRepository<Post, Long> {
}
