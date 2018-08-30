package com.customer.account.auth.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.customer.account.utility.ApplicationConstants;
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
	
	@Autowired
	private Environment environment;
	  @Bean
	    public Docket productApi() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .select().apis(RequestHandlerSelectors.basePackage(environment.getProperty(ApplicationConstants.BASE_PACKAGE)))
	                .paths(Predicates.not(PathSelectors.regex(environment.getProperty(ApplicationConstants.REGEX_FOR_SCAN))))
	                .build()
	                .apiInfo(metaData())
	                .tags(new Tag(environment.getProperty(ApplicationConstants.CUSTOMER_API_TAG),environment.getProperty(ApplicationConstants.CUSTOMER_API_TAG_MESSAGE)),
	                	  new Tag(environment.getProperty(ApplicationConstants.USER_API_TAG),environment.getProperty(ApplicationConstants.USER_API_TAG_MESSAGE))
	                		);
	    }
	  
	  private ApiInfo metaData() {
	        return new ApiInfo(environment.getProperty(ApplicationConstants.SWAGGER_APPLICATION_INFO), environment.getProperty(ApplicationConstants.SWAGGER_APPLICATION_DESC),environment.getProperty(ApplicationConstants.SWAGGER_APPLICATION_VERSION) , environment.getProperty(ApplicationConstants.SWAGGER_APPLICATION_CREATEDBY), new springfox.documentation.service.Contact(environment.getProperty(ApplicationConstants.SWAGGER_APPLICATION_CONTACT), environment.getProperty(ApplicationConstants.SWAGGER_APPLICATION_WEBSITE), environment.getProperty(ApplicationConstants.SWAGGER_APPLICATION_EMAIL)), environment.getProperty(ApplicationConstants.SWAGGER_APPLICATION_LICENCE_VERSION), environment.getProperty(ApplicationConstants.SWAGGER_APPLICATION_LICENCE_URL));
	    }
	
}
