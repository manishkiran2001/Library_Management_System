package com.library.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {

	@Bean
	public ModelMapper beanOfModelMapper()
	{
		return new ModelMapper();
	}
}
