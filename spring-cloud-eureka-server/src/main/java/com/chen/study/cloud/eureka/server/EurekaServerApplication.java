package com.chen.study.cloud.eureka.server;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * /**
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
 *
 *
 * eureka服务器一般不需要自我注册，也不需要注册其它服务器
 * eureka自我注册问题，服务本身没有启动
 *
 * @author 陈添明
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}
