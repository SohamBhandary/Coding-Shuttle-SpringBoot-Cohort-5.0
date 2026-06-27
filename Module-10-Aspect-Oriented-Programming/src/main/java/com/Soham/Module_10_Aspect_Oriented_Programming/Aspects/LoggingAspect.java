//package com.Soham.Module_10_Aspect_Oriented_Programming.Aspects;
//
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
////
////@Aspect
////@Component
////@Slf4j
//public class LoggingAspect {
//
//
//    @Before("execution(* com.Soham.Module_10_Aspect_Oriented_Programming.Services.Imple.ShipmentServiceImpl.*(..))")
//    public void beforeOrderPackage(JoinPoint joinPoint) {
//        log.info("Before called from LoggingAspect, {}", joinPoint.getSignature());
//        log.info("Before called from LoggingAspect, {}", joinPoint.getKind());
//
//    }
//    @Before("within(com.Soham.Module_10_Aspect_Oriented_Programming.Services.Imple.*)")
//    public void beforeWithinOrderPackage(JoinPoint joinPoint) {
//        log.info("Before called from LoggingAspectWithin: {}", joinPoint.getSignature());
//        log.info("JoinPoint Kind: {}", joinPoint.getKind());
//    }
//    @After("execution(* com.Soham.Module_10_Aspect_Oriented_Programming.Services.Imple.ShipmentServiceImpl.*(..))")
//    public void afterOrderPackage(JoinPoint joinPoint) {
//        log.info("After called from LoggingAspect, {}", joinPoint.getSignature());
//
//    }
//    @Before("within(com.Soham.Module_10_Aspect_Oriented_Programming..*)")
//    public void beforeServiceImplCalls() {
//        log.info("Service Impl calls");
//    }
//
//    @Before("transactionalMethods()")
//    public void beforeTransactionalMethod(JoinPoint joinPoint) {
//        log.info("Transactional method called: {}", joinPoint.getSignature());
//    }
//}