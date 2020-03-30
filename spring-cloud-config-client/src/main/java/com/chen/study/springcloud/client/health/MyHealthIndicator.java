package com.chen.study.springcloud.client.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;

/**
 *
 * 自定义实现HealthIndicator
 * 1、实现AbstractHealthIndicator
 * 2、暴露bean
 *
 * 意义：
 * 比如应用可以任意的输出业务的健康指标、系统健康
 *
 * @author 陈添明
 */
public class MyHealthIndicator extends AbstractHealthIndicator {

    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        builder.up().withDetail("MyHealthIndicator", "up up up");
    }
}
