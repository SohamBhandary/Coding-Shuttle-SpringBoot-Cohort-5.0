package com.Soham.Module_10_Aspect_Oriented_Programming.Aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {


    @Before("execution(* com.Soham.Module_10_Aspect_Oriented_Programming.Services.Imple.ShipmentServiceImpl.*(..))")
    public void beforeOrderPackage(JoinPoint joinPoint) {
        log.info("Before called from LoggingAspect, {}", joinPoint.getSignature());

    }
    @After("execution(* com.Soham.Module_10_Aspect_Oriented_Programming.Services.Imple.ShipmentServiceImpl.*(..))")
    public void afterOrderPackage(JoinPoint joinPoint) {
        log.info("After called from LoggingAspect, {}", joinPoint.getSignature());

    }
}