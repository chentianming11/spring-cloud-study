package com.chen.study.spring.cloud.hystrix.client.controller;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author 陈添明
 */
public class FutureDemo {

    private static final Random RANDOM = new Random();

    private static ExecutorService executorService = Executors.newFixedThreadPool(1);

    public static void main(String[] args) {
        Future<String> future = executorService.submit(() -> {
            // 正常流程
            int i = RANDOM.nextInt(200);
            System.out.println("sleep " + i + " ms");
            Thread.sleep(i);
            return "hello, word!";
        });

        try {
            // 线程执行时间如果>100ms，触发熔断
            future.get(100, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
           // 超时流程
            System.out.println("超时保护！");
        }

        executorService.shutdown();
    }
}
