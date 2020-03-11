package com.concon.accountservice.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomBeanFactory {
    @Bean
    public ModelMapper getModelMApper(){
        return new ModelMapper();
    }
}
