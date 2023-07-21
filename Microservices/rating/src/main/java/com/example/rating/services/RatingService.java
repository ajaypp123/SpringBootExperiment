package com.example.rating.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rating.models.Rating;
import com.example.rating.repository.RatingRepository;

@Service
public class RatingService {
    @Autowired
    RatingRepository ratingRepository;

    public Rating saveRating(Rating rating) {
        rating.setRatingId(UUID.randomUUID().toString());
        return ratingRepository.save(rating);
    }

    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    public Rating getRating(String ratingId) throws Exception {
        return ratingRepository.findById(ratingId)
                .orElseThrow(() -> new Exception("Rating not found exception, " + ratingId));
    }

    public List<Rating> getUserRatings(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    public List<Rating> getHotelRatings(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }

    public void deleteRating(String ratingId) {
        ratingRepository.deleteById(ratingId);
    }

    public void deleteAll() {
        ratingRepository.deleteAll();
    }
}
