package com.chen.study.spring.cloud.hystrix.client.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author 陈添明
 */
@RestController
public class HystrixDemoController {

    private static final Random RANDOM = new Random();

    /**
     * 当 {@link #helloWord()}调用失败，fallback方法{@link #errorContext()}作为替代返回
     * @return 。
     */
    @GetMapping("hello-word")
    @HystrixCommand(fallbackMethod = "errorContext",
            // 线程执行时间如果>100ms，触发熔断
            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "100")}
    )
    public String helloWord() throws InterruptedException {
        int i = RANDOM.nextInt(200);
        System.out.println("sleep " + i + " ms");
        Thread.sleep(i);
        return "hello, word!";
    }


    public String errorContext() {
        return "fault";
    }
}
