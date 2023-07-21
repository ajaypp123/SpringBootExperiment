package com.example.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.userservice.models.User;
import com.example.userservice.services.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v1/api/users")
public class UserController {

    @Autowired
    UserService userService;

    private static final String curcuitBrakerName = "userCurcuitBraker";

    @GetMapping("/{userId}")
    @SneakyThrows
    @CircuitBreaker(name = curcuitBrakerName, fallbackMethod = "getUserFailBack")
    public User getUser(@PathVariable String userId) {
        return userService.getUser(userId);
    }

    public User getUserFailBack(Exception e) throws Exception {
        log.error("Failed with case curcuit braker, ", e.getMessage());
        throw e;
    }

    @GetMapping
    // @TimeLimiter(name = "userRequestLimiter", fallbackMethod = "deleteUserFailBack")
    // @Bulkhead(name = "userRequestLimiter", fallbackMethod = "deleteUserFailBack")
    public List<User> getAllUser() {
        return userService.getAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }

    @DeleteMapping
    // @Retry(name = "retryUserDelete", fallbackMethod = "deleteUserFailBack")
    @RateLimiter(name = "userRequestLimiter", fallbackMethod = "deleteUserFailBack")
    public void deleteUser() {
        userService.deleteAll();
    }

    public void deleteUserFailBack(Exception e) {
        log.error("Failed with case curcuit braker, ", e.getMessage());
    }

}
