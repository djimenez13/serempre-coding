package com.serempre.coding.application.config;

import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.serempre.coding.domain.model.user.gateway.UserRepository;
import com.serempre.coding.domain.usecase.user.UserUseCase;
import com.serempre.coding.infrastructure.adapters.mockjpa.user.UserRepositoryAdapter;

@Configuration
@EnableAutoConfiguration
public class AppConfig {
	
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	@Bean
	public UserRepository userRepository() {
		return new UserRepositoryAdapter(restTemplate(), modelMapper());
	}
	
	@Bean
	public UserUseCase userUseCase() {
		return new UserUseCase(userRepository());
	}

}
