package com.example.rating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rating.models.Rating;
import com.example.rating.services.RatingService;

import lombok.SneakyThrows;

@RestController
@RequestMapping("/v1/api/ratings")
public class RatingController {

    @Autowired
    RatingService ratingService;

    @GetMapping("/{ratingId}")
    @SneakyThrows
    public Rating getRating(@PathVariable String ratingId) {
        return ratingService.getRating(ratingId);
    }

    @GetMapping("/user/{userId}")
    public List<Rating> getUserRatings(@PathVariable String userId) {
        return ratingService.getUserRatings(userId);
    }

    @GetMapping("hotel/{hotelId}")
    public List<Rating> getHotelRatings(@PathVariable String hotelId) {
        return ratingService.getHotelRatings(hotelId);
    }

    @GetMapping
    public List<Rating> getAllRating() {
        return ratingService.getAllRatings();
    }

    @PostMapping
    public Rating createRating(@RequestBody Rating rating) {
        return ratingService.saveRating(rating);
    }

    @DeleteMapping("/{id}")
    public void deleteRating(@PathVariable String id) {
        ratingService.deleteRating(id);
    }

    @DeleteMapping
    public void deleteRating() {
        ratingService.deleteAll();
    }

}
