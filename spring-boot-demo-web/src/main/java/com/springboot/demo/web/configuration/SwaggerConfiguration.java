package com.springboot.demo.web.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;

@Configuration
public class SwaggerConfiguration {

  @Bean
  public ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title("Spring Boot Demo")
        .description("built by indraep")
        .build();
  }


}
