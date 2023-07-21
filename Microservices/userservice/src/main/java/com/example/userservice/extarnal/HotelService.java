package com.example.userservice.extarnal;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.userservice.models.Hotel;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {

    @GetMapping("/v1/api/hotels/{hotelId}")
    Hotel getHotel(@PathVariable String hotelId);

}
