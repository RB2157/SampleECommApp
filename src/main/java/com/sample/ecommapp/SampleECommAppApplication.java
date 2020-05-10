package com.sample.ecommapp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * The main class for intitializing the application.
 * 
 * @author ronbaner
 *
 */

@EnableJpaRepositories(basePackages = { "com.sample.dao" })
@EntityScan(basePackages = { "com.sample.entities" })
@SpringBootApplication(scanBasePackages = { "com.sample.controllers", "com.sample.configurations",
		"com.sample.services" })
public class SampleECommAppApplication {
	
	private static final Logger LOGGER = LogManager.getLogger(SampleECommAppApplication.class);

	public static void main(String[] args) {
		LOGGER.info("Into main()");
		SpringApplication.run(SampleECommAppApplication.class, args);
	}

}
