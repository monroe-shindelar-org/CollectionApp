package com.mshindelar.collection.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mshindelar.collection.converter.CsvHttpMessageConverter;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.multipart.MultipartResolver;

import java.util.List;

@Configuration
@EnableScheduling
public class CollectionConfig {

    @Bean
    public HttpClient httpClient() { return HttpClientBuilder.create().build(); }

    @Bean
    public ObjectMapper objectMapper() { return new ObjectMapper(); }

    @Bean
    public ModelMapper modelMapper() { return new ModelMapper(); }
}
