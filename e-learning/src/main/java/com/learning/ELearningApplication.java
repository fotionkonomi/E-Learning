package com.learning;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;
import org.springframework.hateoas.support.WebStack;

@SpringBootApplication
@EnableHypermediaSupport(stacks = WebStack.WEBMVC, type = HypermediaType.HAL)
public class ELearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(ELearningApplication.class, args);	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
}
