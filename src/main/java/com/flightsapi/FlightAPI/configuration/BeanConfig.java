package com.flightsapi.FlightAPI.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flightsapi.FlightAPI.exception.RestExceptionHandler;
import org.modelmapper.ModelMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfig {

    @Bean
    public RestExceptionHandler restExceptionHandler() {
        return new RestExceptionHandler();
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder
                .rootUri("http://api.aviationstack.com")
                .errorHandler(restExceptionHandler())
                .build();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    //TODO Dodaj exceptionHandler do restTemplateBuilder

}
