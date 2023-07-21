package com.example.hotelservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ComponentScan
@SpringBootApplication
public class HotelserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelserviceApplication.class, args);
		log.info("Hotel Service application started ....");
	}

}
