package com.example.hotelservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hotelservice.models.Hotel;
import com.example.hotelservice.services.HotelService;

import lombok.SneakyThrows;

@RestController
@RequestMapping("/v1/api/hotels")
public class HotelController {

    @Autowired
    HotelService hotelService;

    @GetMapping("/{hotelId}")
    @SneakyThrows
    public Hotel getHotel(@PathVariable String hotelId) {
        return hotelService.getHotel(hotelId);
    }

    @GetMapping
    public List<Hotel> getAllHotel() {
        return hotelService.getAllHotels();
    }

    @PostMapping
    public Hotel createHotel(@RequestBody Hotel hotel) {
        return hotelService.saveHotel(hotel);
    }

    @DeleteMapping("/{id}")
    public void deleteHotel(@PathVariable String id) {
        hotelService.deleteHotel(id);
    }

    @DeleteMapping
    public void deleteHotel() {
        hotelService.deleteAll();
    }

}
