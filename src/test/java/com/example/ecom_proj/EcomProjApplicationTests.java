package com.example.ecom_proj;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EcomProjApplicationTests {
	
	public static Logger logger = LoggerFactory.getLogger(EcomProjApplicationTests.class);

	@Test
	void contextLoads() {
		logger.info("Test case executing.");
		assertEquals(true, true);
	}

}
