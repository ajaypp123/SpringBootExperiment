package com.example.userservice.extarnal;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.userservice.models.Rating;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

    @GetMapping("/v1/api/ratings/user/{userId}")
    List<Rating> getRatings(@PathVariable("userId") String userId);

}
