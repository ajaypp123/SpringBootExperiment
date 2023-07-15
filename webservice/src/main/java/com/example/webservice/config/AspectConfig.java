package com.example.webservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.example.webservice.aspect.AuditTrailAspect;

@Configuration
@EnableAspectJAutoProxy
public class AspectConfig {
    @Bean
    AuditTrailAspect auditTrailAspect() {
        return new AuditTrailAspect();
    }
}
