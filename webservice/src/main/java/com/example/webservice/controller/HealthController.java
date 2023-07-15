package com.example.webservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.webservice.service.HelpService;

@RestController
@RequestMapping("/v1/api/health")
public class HealthController {
    @Autowired
    HelpService help;

    @GetMapping("/check")
    public String getHealthCheck() {
        return help.doSomethingAround();
    }

    @GetMapping
    public String getHealth() {
        return help.doSomething();
    }
}
