package com.Soahm.Module_19_Reactive_Basics;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class Module19ReactiveBasicsApplication implements CommandLineRunner {

	private final LearnReactor learnReactor;

	public static void main(String[] args) {
		SpringApplication.run(Module19ReactiveBasicsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		learnReactor.learnReactor();

	}
}
