package com.example.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.userservice.models.User;

public interface UserRepository extends JpaRepository <User, String> {
}
