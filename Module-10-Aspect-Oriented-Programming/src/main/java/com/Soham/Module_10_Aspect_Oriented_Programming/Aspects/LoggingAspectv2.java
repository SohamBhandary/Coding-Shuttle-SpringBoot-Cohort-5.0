package com.Soham.Module_10_Aspect_Oriented_Programming.Aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspectv2 {

    @Before("allServiceMethods()")
    public void beforeServiceMethod(JoinPoint joinPoint) {
        log.info("Before Advice: {}", joinPoint.getSignature());
    }
//    @After("allServiceMethods()")
@AfterReturning(value = "allServiceMethods()", returning = "returnedObj")
public void afterServiceMethod(JoinPoint joinPoint, Object returnedObj) {
    log.info("After Returning Advice: {}", joinPoint.getSignature());
    log.info("Returned Value: {}", returnedObj);
}

    @AfterThrowing(value = "allServiceMethods()")
    public void afterServiceMethod2(JoinPoint joinPoint) {
        log.info("After Returning AdviceException: {}", joinPoint.getSignature());
    }



    @Pointcut("execution(* com.Soham.Module_10_Aspect_Oriented_Programming.Services.Imple.*.*(..))")
    public void allServiceMethods() {
    }
}