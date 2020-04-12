package com.chen.study.springcloudserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 *  介绍Environment仓储
 * 	1、概念
 * 		- {application}: 配置使用客户端spring.profiles.active
 * 		- {profile}: 客户端spring.profiles.active配置
 * 		- {label}: 服务端配置文件版本标识
 * 	2、git实现
 * 		-服务端配置
 * 			spring.cloud.config.server.git.uri
 * 			spring.cloud.config.server.git.*
 * 		-客户端配置
 * 			spring.cloud.config.uri
 * 			spring.cloud.config.name
 * 			spring.cloud.config.profile
 * 			spring.cloud.config.label
 *
 *  构建spring cloud配置服务器
 *  1、实现步骤
 *  	- 在Config Class上加上@EnableConfigServer
 *  	- 配置文件目录（基于git）
 *  		- app.properties
 *  		- app-test.properties
 *  		- app-prod.properties
 *  	- 服务端配置 配置版本仓库（本地）
 *
 *
 * @author mac
 */
@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class SpringCloudServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudServerApplication.class, args);
	}

}
