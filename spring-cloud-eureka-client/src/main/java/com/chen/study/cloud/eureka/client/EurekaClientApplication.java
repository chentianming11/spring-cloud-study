package com.chen.study.cloud.eureka.client;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 *  服务发现：
 *  1、 客户端
 *      netfilx eureka client
 *      依赖：spring-cloud-starter-eureka
 *      api：EurekaClient、ServiceInstance
 *  2、spring cloud commons
 *
 * 服务注册：
 *  1、客户端
 *      netfilx eureka client
 *      激活：@EnableEurekaClient
 *      健康指标：HealthIndicator
 *
 *  2、服务端
 *      netfilx eureka server
 *      激活：@EnableEurekaServer
 * @author 陈添明
 */
@SpringBootApplication
@EnableEurekaClient
public class EurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }
}
