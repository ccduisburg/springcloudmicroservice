package com.concon.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.management.modelmbean.ModelMBeanAttributeInfo;

@Configuration //bu class ta Bean lari oluturup kullanmak icin olusturuyoruz
public class TicketConfiguration {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
