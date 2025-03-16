package com.objectia.JBD_HandsOnLearning.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {


    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI().info(new Info().title("JBDP Apis").description("Api documentation for JBDP").version("1.0"));
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder().group("public").packagesToScan("com.objectia.JBD_HandsOnLearning").build();
    }


}
