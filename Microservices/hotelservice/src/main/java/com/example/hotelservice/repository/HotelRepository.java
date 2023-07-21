package com.example.hotelservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hotelservice.models.Hotel;

public interface HotelRepository extends JpaRepository <Hotel, String> {
}
