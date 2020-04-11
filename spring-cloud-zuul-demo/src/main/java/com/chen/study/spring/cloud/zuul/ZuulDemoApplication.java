package com.chen.study.spring.cloud.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 *
 * 1、增加@EnableZuulProxy
 * 2、配置路由规则：zuul.routes.${app-name}=/${app-url-prefix}/**
 * @author 陈添明
 */
@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class ZuulDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulDemoApplication.class, args);
    }
}
