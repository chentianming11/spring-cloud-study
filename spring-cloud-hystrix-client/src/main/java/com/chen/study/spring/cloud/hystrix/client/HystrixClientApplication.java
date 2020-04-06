package com.chen.study.spring.cloud.hystrix.client;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

/**
 *
 * @author 陈添明
 */
@SpringBootApplication
// 激活，但是没有spring cloud功能
//@EnableHystrix
// 激活熔断保护器  hystrix.stream
@EnableCircuitBreaker
public class HystrixClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixClientApplication.class, args);
    }
}
