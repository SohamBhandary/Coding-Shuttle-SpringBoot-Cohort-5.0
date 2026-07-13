package com.soham.Module_18_MultiThreading_Async_Task_Scheduling;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@Slf4j
public class Module18MultiThreadingAsyncTaskSchedulingApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(Module18MultiThreadingAsyncTaskSchedulingApplication.class, args);

		ThreadPoolExecutor threadPoolExecutor=
				new ThreadPoolExecutor(4,
						6, 2,
						TimeUnit.SECONDS, new ArrayBlockingQueue<>(10),
                        (r, executor) -> {

					log.info("Rejected and retrying");
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
							executor.submit(r);

                        });

		log.info("Starting main thread.... {}",Thread.currentThread().getName());

		for(int i=0;i<10;i++) {
			threadPoolExecutor.submit(new LongRunningTask());

		}
		log.info("Ending main thread.... {}", Thread.currentThread().getName());




	}

}
