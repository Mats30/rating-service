package com.rataj.ratingservice.config;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.time.LocalDate;
import java.util.Map;

@Configuration
class JacksonConfiguration {

    @Bean
    ObjectMapper objectMapper() {
        return Jackson2ObjectMapperBuilder.json()
                .serializersByType(customSerializers())
                .deserializersByType(customDeserializers())
                .build();
    }

    private Map<Class<?>, JsonSerializer<?>> customSerializers() {
        return Map.of(LocalDate.class, new LocalDateSerializer());
    }

    private Map<Class<?>, JsonDeserializer<?>> customDeserializers() {
        return Map.of(LocalDate.class, new LocalDateDeserializer());
    }


}
