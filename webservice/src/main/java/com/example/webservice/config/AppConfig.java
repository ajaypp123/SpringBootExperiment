package com.example.webservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@Primary
@ConfigurationProperties("app")
public class AppConfig {
    @Value("${app.service.env}")
    private String serviceEnv;

    public String getServiceEnv() {
        return serviceEnv;
    }

    public void setServiceEnv(String serviceEnv) {
        this.serviceEnv = serviceEnv;
    }

}
