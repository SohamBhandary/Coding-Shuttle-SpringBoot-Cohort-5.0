package com.soham.Module_18_MultiThreading_Async_Task_Scheduling;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.*;

@SpringBootApplication
@Slf4j
public class Module18MultiThreadingAsyncTaskSchedulingApplication {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		SpringApplication.run(Module18MultiThreadingAsyncTaskSchedulingApplication.class, args);

		// Custom executor using non-daemon user threads to keep the app alive after main finishes
		ExecutorService customExecutor = Executors.newFixedThreadPool(2);

		learnCompletableFuture(customExecutor);

		log.info("Main thread has finished and ended!");

		customExecutor.shutdown();
	}

	static void learnCompletableFuture(ExecutorService executor) {
		CompletableFuture.supplyAsync(() -> {
					try {
						return getName();
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
						throw new IllegalStateException(e);
					}
				}, executor)
				// 1. thenApply: Transforms the result from "Soham" to "Hello, Soham!"
				.thenApply(name -> {
					log.info("Transforming name in thenApply...");
					return "Hello, " + name + "!";
				})
				// 2. exceptionally: Catches any errors in the chain and provides a fallback value
				.exceptionally(throwable -> {
					log.error("An error occurred in the chain: {}", throwable.getMessage());
					return "Hello, Guest!"; // Fallback result
				})
				// 3. thenAccept: Consumes the final result (either the transformed string or the fallback)
				.thenAccept(finalResult -> {
					log.info("Final Result: {}", finalResult);
				});
	}

	static String getName() throws InterruptedException {
		Thread.sleep(3000);

		// Simulating a random failure to test exceptionally (Toggle true/false to test)
		boolean simulateError = false;
		if (simulateError) {
			throw new RuntimeException("Database timeout exception!");
		}

		return "Soham";
	}
}