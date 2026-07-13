package com.soham.Module_18_MultiThreading_Async_Task_Scheduling;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class Module18MultiThreadingAsyncTaskSchedulingApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(Module18MultiThreadingAsyncTaskSchedulingApplication.class, args);

		log.info("Before : {}",Thread.currentThread().getState());
		Thread worker= new Thread(
                () -> {
					log.info("From thread : {}",Thread.currentThread().getState());
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
        );



		worker.start();
      worker.join(); //blocks the execution of calling thread
		log.info("After : {}",Thread.currentThread().getState());
	}

}
