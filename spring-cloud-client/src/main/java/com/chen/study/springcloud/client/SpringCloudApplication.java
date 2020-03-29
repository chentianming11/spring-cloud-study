package com.chen.study.springcloud.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * spring cloud事件、监听器：
 * 	BootStrapApplicationListener
 * 		1、负责加载 bootstrap.properties
 * 		2、负责初始化 BootStrapApplicationContext, 根上下文
 *
 * spring Environment：
 * 	1、StandardEnvironment
 * 	2、StandardServletEnvironment
 * 	Environment关联着一个propertySources对象，propertySources包含多个PropertySource！
 * 	比较常用的PropertySource有：SystemEnvironmentPropertySource- System.properties
 * 		SystemEnvironmentPropertySource - System.getEnv
 *
 * 	Bootstrap配置属性
 * 	- bootstrap配置文件路径：spring.cloud.bootstrap.location
 * 	- 覆盖远程配置属性：spring.cloud.config.allowOverride
 * 	- 自定义bootstrap配置：@BootstrapConfiguration
 * 	- 自定义bootstrap配置属性源：PropertySourceLocator
 *

 * @author mac
 */
@SpringBootApplication
public class SpringCloudApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(SpringCloudApplication.class);
		springApplication.setWebEnvironment(true);
		springApplication.run(args);
	}


	/**
	 * 实现自定义配置
	 * 1、实现PropertySourceLocator
	 * 2、暴露该实现为一个bean
	 * 3、实现PropertySource
	 * 4、配置spring.factories
	 */

	@Configuration
	@Order(0)
	public static class MyPropertySourceLoader implements PropertySourceLocator {

		@Override
		public PropertySource<?> locate(Environment environment) {
			Map<String, Object> source = new HashMap<>();
			source.put("server.port", "9090");
			MapPropertySource propertySource = new MapPropertySource("my-property-source", source);
			return propertySource;
		}
	}


}
