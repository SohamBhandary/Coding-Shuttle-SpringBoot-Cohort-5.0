package com.soham.Module_18_MultiThreading_Async_Task_Scheduling;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MyController {

    private final ThreadPoolTaskExecutor threadPoolTaskExecutor;
    private final StudentService studentService;

    @GetMapping("/info")
    public ResponseEntity<Student> getStudentInfo() {


        log.info("starting.. {}", Thread.currentThread().getName());
        Student student = studentService.getStudentInfo();

        return ResponseEntity.ok(student);
    }
}
