package com.test.irbis.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигурация для свагера
 */
@Configuration
public class OpenApiConfiguration {

  @Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI()
            .components(new Components())
            .info(new Info().title("News Application API").description(
                    "This is a test Spring Boot RESTful service for Irbis by Vlad Markov"));
  }
}
