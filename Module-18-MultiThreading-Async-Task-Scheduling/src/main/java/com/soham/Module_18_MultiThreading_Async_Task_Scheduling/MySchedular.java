package com.soham.Module_18_MultiThreading_Async_Task_Scheduling;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MySchedular {

    @Scheduled(cron = "0 0 12 * * *")
//    @Scheduled(cron = "* * * * * *")
    void log(){
        log.info("Logged 1");

    }
//    @Scheduled(fixedRateString = "1000")
//    void log2(){
//        log.info("Logged 2");
//
//    }
}
