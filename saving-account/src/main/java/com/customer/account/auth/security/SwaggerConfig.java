package com.customer.account.auth.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
	  @Bean
	    public Docket productApi() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .select().apis(RequestHandlerSelectors.basePackage("com.customer.account.controller"))
	                .paths(Predicates.not(PathSelectors.regex("/api*")))
	                .build()
	                .apiInfo(metaData())
	                .tags(new Tag("Customer Api"," Spring Boot Customer Operations for bank account."),
	                	  new Tag("User Api"," Spring Boot Customer Operations Authentication.")
	                		);
	    }
	  
	  private ApiInfo metaData() {
	        return new ApiInfo("Customer Bank Details Spring Boot App", "Spring Boot App for Bank Customer operations", "1.0", "Altimetrik India Pvt. Ltd", new springfox.documentation.service.Contact("Altimetrik India", "www.altimetrik.com", "info@altimetrik.com"), "Apache License Version 2.0", "https://www.apache.org/licenses/LICENSE-2.0");
	    }
	
}
