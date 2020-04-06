package com.chen.study.spring.cloud.hystrix.client.controller;

import com.netflix.hystrix.HystrixCommandGroupKey;
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


    /**
     * 编码方式使用熔断器
     * @return
     * @throws InterruptedException
     */
    @GetMapping("hello-word2")
    public String helloWord2() throws InterruptedException {
        return new HelloWordCommand()
                .execute();
    }


    public static class HelloWordCommand extends com.netflix.hystrix.HystrixCommand<String> {

        protected HelloWordCommand() {
            super(HystrixCommandGroupKey.Factory.asKey("helloWord"), 100);
        }

        @Override
        protected String run() throws Exception {
            int i = RANDOM.nextInt(200);
            System.out.println("sleep " + i + " ms");
            Thread.sleep(i);
            return "hello, word!";
        }

        @Override
        protected String getFallback() {
            return "fault";
        }
    }
}
