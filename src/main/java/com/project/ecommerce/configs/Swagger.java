package com.project.ecommerce.configs;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
		info = @Info(title = "ecommerce", 
		version = "1.0.0," )
		)
public class Swagger {

}
