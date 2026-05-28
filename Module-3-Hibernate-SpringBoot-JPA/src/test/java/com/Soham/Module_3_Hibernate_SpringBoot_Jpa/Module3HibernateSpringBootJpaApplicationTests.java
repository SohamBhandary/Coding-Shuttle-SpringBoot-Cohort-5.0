package com.Soham.Module_3_Hibernate_SpringBoot_Jpa;

import com.Soham.Module_3_Hibernate_SpringBoot_Jpa.Entities.Product;
import com.Soham.Module_3_Hibernate_SpringBoot_Jpa.Repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class Module3HibernateSpringBootJpaApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testRepository(){
		Product product=Product.builder().sku("tea").title("tata").price("fifty")
				.quantity(12).build();
	Product saved=	productRepository.save(product);
		System.out.println(saved);

	}

	@Test
	void getRepo(){
		Product product=productRepository.findByTitle("tata");
		System.out.println(product);

	}
	@Test
	void getTitle(){
		List<Product> product=productRepository.findByTitleLike("%ta%");
		System.out.println(product);

	}

}
