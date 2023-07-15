package com.example.webservice.controller;

import java.util.List;

import javax.ws.rs.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.webservice.model.User;
import com.example.webservice.repo.UserRepo;

@RestController
@RequestMapping("/v1/api/users")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userRepo.findById(id)
            .orElseThrow(() -> new NotFoundException("User not found with id: " + id));
    }

    @GetMapping
    public Page<User> getUsersByPage(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return userRepo.findAll(pageable);
    }

    @GetMapping("/getUserPostCounts")
    public List<Object[]> getUsersWithPostCounts() {
        return userRepo.getUsersWithPostCountLessThanTen();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepo.save(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        User existingUser = userRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found with id: " + id));

        existingUser.setName(user.getName());
        return userRepo.save(existingUser);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found with id: " + id));

        userRepo.delete(user);
    }
}
