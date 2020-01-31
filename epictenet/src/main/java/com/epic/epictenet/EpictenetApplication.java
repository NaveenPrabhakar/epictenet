package com.epic.epictenet;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@SpringBootApplication
@EnableSwagger2
public class EpictenetApplication {

	public static void main(String[] args) {
		SpringApplication.run(EpictenetApplication.class, args);
	}
	
	
	
	@Bean
	public Docket swaggerConfigeration(){
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				//.paths(PathSelectors.ant("/*"))
				.apis(RequestHandlerSelectors.basePackage("com.epic.epictenet.controller"))
				.build()
				.apiInfo(apidetails());
		
		
	}


	private ApiInfo apidetails() {
		return new ApiInfo(
				"Naveen API Doc", "Api to create Post and add comment" ,"1.0" ,"", "",  "Naveen Prabhakar", "8105181845"
				);
	}

	
}
