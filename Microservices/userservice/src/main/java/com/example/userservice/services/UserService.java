package com.example.userservice.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.userservice.extarnal.HotelService;
import com.example.userservice.extarnal.RatingService;
import com.example.userservice.models.Hotel;
import com.example.userservice.models.Rating;
import com.example.userservice.models.User;
import com.example.userservice.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RatingService ratingService;

    @Autowired
    HotelService hotelService;

    public User saveUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(String userId) throws Exception {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new Exception("User not found exception, " + userId));

        List<Rating> ratings = ratingService.getRatings(userId);

        if (ratings != null) {
            List<Rating> ratingList = ratings.stream().map(rating -> {

                Hotel hotel = hotelService.getHotel(rating.getHotelId());
                rating.setHotel(hotel);
                return rating;
            }).collect(Collectors.toList());
            user.setRatings(ratingList);
        }
        return user;
    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }
}
