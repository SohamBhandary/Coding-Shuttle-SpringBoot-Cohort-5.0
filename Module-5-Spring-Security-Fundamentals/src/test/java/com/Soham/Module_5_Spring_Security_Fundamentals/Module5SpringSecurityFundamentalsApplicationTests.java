package com.Soham.Module_5_Spring_Security_Fundamentals;

import com.Soham.Module_5_Spring_Security_Fundamentals.Entities.User;
import com.Soham.Module_5_Spring_Security_Fundamentals.Services.JWTSerivce;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Module5SpringSecurityFundamentalsApplicationTests {

	@Autowired
	private JWTSerivce jwtSerivce;

	@Test
	void contextLoads() {

		User user= new User(4L,"soham@gmail.com","1234");
		 String token= jwtSerivce.generateToken(user);
		System.out.println(token);
		Long id=jwtSerivce.getUserIdFromToken(token);
		System.out.println(id);

	}

}
