package com.concon.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration //bu class ta Bean lari oluturup kullanmak icin olusturuyoruz
@EnableElasticsearchRepositories
@EnableJpaRepositories("com.concon")
@ComponentScan("com.concon")
public class TicketConfiguration {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
