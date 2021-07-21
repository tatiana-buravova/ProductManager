package com.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductManagerApplicationTest {
	
	@Autowired
	private ProductController productController;
	
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(productController).isNotNull();
		
		
		
	}

}
