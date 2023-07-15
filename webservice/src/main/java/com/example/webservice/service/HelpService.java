package com.example.webservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webservice.aspect.AuditTrail;
import com.example.webservice.config.AppConfig;

@Service
public class HelpService {

    @Autowired
    AppConfig config;

    public String doSomething() {
        System.out.println(config.getServiceEnv());
        return "Healthy";
    }

    @AuditTrail
    public String doSomethingAround() {
        return "Healthy";
    }
}
