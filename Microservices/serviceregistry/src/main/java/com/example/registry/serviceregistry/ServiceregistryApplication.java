package com.example.registry.serviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@EnableEurekaServer
public class ServiceregistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceregistryApplication.class, args);
		log.info("Service Registry Application started ...");
	}
}
