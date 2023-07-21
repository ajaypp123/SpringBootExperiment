package com.example.hotelservice.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotelservice.models.Hotel;
import com.example.hotelservice.repository.HotelRepository;

@Service
public class HotelService {
    @Autowired
    HotelRepository hotelRepository;

    public Hotel saveHotel(Hotel hotel) {
        hotel.setId(UUID.randomUUID().toString());
        return hotelRepository.save(hotel);
    }

    public List<Hotel> getAllHotels() {
        return (List<Hotel>) hotelRepository.findAll();
    }

    public Hotel getHotel(String hotelId) throws Exception {
        return hotelRepository.findById(hotelId)
                .orElseThrow(() -> new Exception("Hotel not found exception, " + hotelId));
    }

    public void deleteHotel(String hotelId) {
        hotelRepository.deleteById(hotelId);
    }

    public void deleteAll() {
        hotelRepository.deleteAll();
    }
}
