package com.Soham.Module_20_Webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;

@SpringBootApplication
@EnableR2dbcAuditing
public class Module20WebfluxApplication {

	public static void main(String[] args) {
		SpringApplication.run(Module20WebfluxApplication.class, args);
	}

}
