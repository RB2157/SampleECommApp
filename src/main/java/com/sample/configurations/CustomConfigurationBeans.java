package com.sample.configurations;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The Spring Boot Configuration class for creating the beans.
 * 
 * @author ronbaner
 *
 */

@Configuration
public class CustomConfigurationBeans {

	/**
	 * Model Mapper Bean.
	 * 
	 * @return model mapper
	 */
	@Bean
	public ModelMapper modelMapper() {
		 return new ModelMapper();
	}
}
