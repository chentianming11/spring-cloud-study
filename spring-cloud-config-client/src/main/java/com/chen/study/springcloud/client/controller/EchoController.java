package com.chen.study.springcloud.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 陈添明
 */
@RestController
@RefreshScope
public class EchoController {

    @Value("${user.name}")
    private String userName;


    @GetMapping("/user")
    public String getUser() {
        return userName;
    }
}
