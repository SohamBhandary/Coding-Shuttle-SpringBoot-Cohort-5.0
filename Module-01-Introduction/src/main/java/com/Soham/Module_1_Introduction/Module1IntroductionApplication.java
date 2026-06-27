package com.Soham.Module_1_Introduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class Module1IntroductionApplication implements CommandLineRunner {

//	@Autowired
//	PaymentService paymentService;


	private final NotificationServcie notificationServcie;

	//constructor Injection
	public Module1IntroductionApplication(@Qualifier("smsNoti") NotificationServcie notificationServcie){
		this.notificationServcie=notificationServcie;
	}






	public static void main(String[] args) {
		SpringApplication.run(Module1IntroductionApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
//		paymentService.pay();
		notificationServcie.send();

	}
}
