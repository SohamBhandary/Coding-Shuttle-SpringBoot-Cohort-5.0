package com.Soham.Module_7_Springboot_Testing;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
@Slf4j
class Module7SpringbootTestingApplicationTests {

//	@Test
//	void contextLoads() {
//	}

	@BeforeEach
	void setUp() {
		log.info("This will run Before every method");
	}

	@AfterEach
	void tearDown() {
		log.info("This will run After every method");
	}

	@BeforeAll
	static void setUpOnce() {
		log.info("Setup Once...");
	}

	@AfterAll
	static void tearDownOnce() {
		log.info("Tearing down all...");
	}


	@Test
	@DisplayName("addtest")
	void testadd2numsTest(){
		int a=5;
		int b=5;
		int res=add2nums(a,b);
		log.info("Executing.......................");
		Assertions.assertThat(res).isEqualTo(10);
//		Assertions.assertThat("Apple").isEqualTo("Apple").endsWith("e");

	}

	int add2nums(int a ,int b){
		return a+b;
	}

	double divideTwoNumbers(int a, int b) {
		try {
			return a/b;
		} catch (ArithmeticException e) {
			log.error("Arithmentic excepiton occured: "+e.getLocalizedMessage());
			throw new ArithmeticException("Tried to divide by zero");
		}
	}

	@Test
//	@DisplayName("displayTestNameTwo")
	void testDivideTwoNumbers_whenDenominatorIsZero_ThenArithmeticException() {

		int a = 5;
		int b = 0;

		assertThatThrownBy(() -> divideTwoNumbers(a, b))
				.isInstanceOf(ArithmeticException.class)
				.hasMessage("Tried to divide by zero");

	}
}
