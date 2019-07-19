package com.sergey.hometask.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ItemConfig {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("Sergey Muzika").apiInfo(apiInfo()).select()
				.paths(regex("/item.*")).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Invertory")
				.description("H2 database ui: " + "http://localhost:8080/h2-console " + "\n\n" + "Spring boot app exposing Swagger Api. "
						+ "Done by Sergey Muzika")
				.termsOfServiceUrl("")
				.license("")
				.licenseUrl("").version("1.0").build();
	}
}

