package com.soham.Module_18_MultiThreading_Async_Task_Scheduling;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class StudentInfoService {

    @Async
    public CompletableFuture<String> getName() throws InterruptedException {
        log.info("Getting the name...{}", Thread.currentThread().getName());
        Thread.sleep(2000);
        log.info("Returning name");
        return CompletableFuture.completedFuture("Soham");
    }

    @Async
    public CompletableFuture<String> getId() throws InterruptedException {
        log.info("Getting the id...{}", Thread.currentThread().getName());
        Thread.sleep(2000);
        log.info("Returning id");
        return CompletableFuture.completedFuture("817IT2015");
    }

    @Async
    public CompletableFuture<String> getCollege() throws InterruptedException {
        log.info("Getting the college...{}", Thread.currentThread().getName());
        Thread.sleep(2000);
        log.info("Returning college");
        return CompletableFuture.completedFuture("TCH");
    }
}