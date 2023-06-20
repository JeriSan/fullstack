package com.backend;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = {"com.backend"})
public class FullStackConf {
    @Bean
    @Primary
    public Module datatypeHibernateModule() {
        Hibernate5Module module = new Hibernate5Module();
        //module.enable(Hibernate5Module.Feature.FORCE_LAZY_LOADING);
        //module.configure(Hibernate5Module.Feature.FORCE_LAZY_LOADING, true);
        return module;
    }

/* forzar una conf del object mapper//clase importante que da jackson
    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.registerModule(new Hibernate5Module());
        return objectMapper;
    }
*/
}