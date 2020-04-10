package com.chen.study.spring.cloud.person.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 陈添明
 */
@SpringBootApplication
@EnableEurekaClient
public class PersonServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonServiceApplication.class, args);
    }
}
