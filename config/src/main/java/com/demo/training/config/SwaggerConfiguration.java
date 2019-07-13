package com.demo.training.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.async.DeferredResult;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableAspectJAutoProxy
public class SwaggerConfiguration {
  @Bean
  public AOPAspect aopAspect() {
    return new AOPAspect();
  }

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.any())
        .apis(RequestHandlerSelectors.basePackage("com.demo.training")).build()
        .genericModelSubstitutes(DeferredResult.class, ResponseEntity.class)
        .globalOperationParameters(Arrays.asList(
            new ParameterBuilder().name("character").parameterType("header")
                .modelRef(new ModelRef("string")).required(true).defaultValue("autoFilledFromSwagger")
                .description("unique id per request").build(),
            new ParameterBuilder().name("username").parameterType("header")
                .modelRef(new ModelRef("string")).required(false).defaultValue("system")
                .description("client's username").build()));
  }
}
