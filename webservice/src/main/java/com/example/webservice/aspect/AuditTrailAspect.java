package com.example.webservice.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AuditTrailAspect {
    @Before("execution(* com.example.webservice.service.HelpService.*(..))")
    public void beforeMethodExecution(JoinPoint joinPoint) {
        System.out.println("Logging before method execution: " + joinPoint.getSignature().getName());
    }

    @After("execution(* com.example.webservice.service.HelpService.*(..))")
    public void afterMethodExecution(JoinPoint joinPoint) {
        System.out.println("Logging after method execution: " + joinPoint.getSignature().getName());
    }

    @Around("@annotation(com.example.webservice.aspect.AuditTrail)")
    public Object aroundMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Logging around method execution: " + joinPoint.getSignature().getName());
        Object output = joinPoint.proceed();
        return output;
    }
}
