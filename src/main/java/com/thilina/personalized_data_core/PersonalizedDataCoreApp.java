package com.thilina.personalized_data_core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PersonalizedDataCoreApp {

    public static void main(String[] args) {
        SpringApplication.run(PersonalizedDataCoreApp.class, args);
    }

}
