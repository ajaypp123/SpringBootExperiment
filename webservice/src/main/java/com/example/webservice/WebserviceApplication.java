package com.example.webservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import com.example.webservice.config.AppConfig;

@SpringBootApplication
@ComponentScan
@EnableConfigurationProperties(AppConfig.class)
public class WebserviceApplication {

	static final Logger LOGGER = LoggerFactory.getLogger(WebserviceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(WebserviceApplication.class, args);
		LOGGER.info("Application Started {} ....", args.toString());
	}

}
