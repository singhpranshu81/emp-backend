package com.mph.sprbootdemo.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

	@Bean
public OpenAPI customOpenAPI() {
	return new OpenAPI().info(new Info().title("Employee Mngmt API").description("API documentstion for employee and departments").version("1.0"));
}
	@Bean
	public GroupedOpenApi publicApi() {
		return GroupedOpenApi.builder().group("sprbootdemo").pathsToMatch("/sprbootdemo/**").build();
	}
}
