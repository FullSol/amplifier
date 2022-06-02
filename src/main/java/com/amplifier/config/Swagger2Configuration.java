package com.amplifier.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Configuration {

    @Bean
    public Docket swaggerConfiguration() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/api/v1/*"))
                .apis(RequestHandlerSelectors.basePackage("com.amplifier"))
                .build()
                .enableUrlTemplating(true)
                .apiInfo(apiDetails());
    }

    private ApiInfo apiDetails() {
        return new ApiInfo(
                "AmplifierAPI",
                "Fansite API for Diablo III",
                "1.0",
                "Free to use",
                new springfox.documentation.service.Contact("Calvin Raines", "http://calvinraines.com",
                        "calvin391@revature.net"),
                "API License",
                "http://calvinraines.com",
                Collections.emptyList());
    }
}
