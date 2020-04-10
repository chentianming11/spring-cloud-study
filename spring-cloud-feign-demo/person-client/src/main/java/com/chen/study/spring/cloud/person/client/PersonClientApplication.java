package com.chen.study.spring.cloud.person.client;

import com.chen.study.spring.could.api.service.PersonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 声明式web服务客户端：feign
 声明式：接口声明、注解驱动
 web服务：http通信协议
 feign：不是spring mvc的实现，而是spring cloud封装，使其支持springMVC

 需要的服务组件：
 1、注册中心eureka：用于服务注册和发现
 1.1、应用名称：spring-cloud-eureka-server
 1.2、端口：9090
 2、feign客户（服务消费）端：调用Feign声明接口
 1.1、应用名称：person-client
 1.2、端口：8080
 3、feign服务(服务提供) 端：实现Feign声明接口
 1.1、应用名称：person-service
 1.2、端口：18081
 4、Feign声明接口（契约）：定义一种Java类型的接口
 1.1、声明接口：person-api
 * @author 陈添明
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(clients = {PersonService.class})
@ComponentScan("com.chen.study")
@EnableHystrix
//@RibbonClient(value = "person-service", configuration = PersonClientApplication.class)
public class PersonClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonClientApplication.class, args);
    }

    @Bean
    public FirstServerForeverRule firstServerForeverRule() {
        return new FirstServerForeverRule();
    }
}
