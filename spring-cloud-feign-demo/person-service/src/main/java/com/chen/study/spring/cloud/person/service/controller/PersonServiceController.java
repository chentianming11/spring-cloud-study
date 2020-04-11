package com.chen.study.spring.cloud.person.service.controller;

import com.chen.study.spring.could.api.domain.Person;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * PersonService 实现
 * 可选实现 PersonService 接口
 * @author 陈添明
 */
@RestController
public class PersonServiceController {

    private static final Random RANDOM = new Random();

    private Map<Long, Person> personMap = new ConcurrentHashMap<>();

    /**
     * .
     *
     * @param person .
     * @return .
     */
    @PostMapping(value = "/person/save")
    public boolean save(@RequestBody Person person) {
        return personMap.put(person.getId(), person) == null;
    }

    /**
     * .
     *
     * @return .
     */
    @GetMapping(value = "/person/findAll")
    @HystrixCommand(fallbackMethod = "fallbackFindAll",
            // 线程执行时间如果>100ms，触发熔断
            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "100")}
    )
    public Collection<Person> findAll() throws InterruptedException {
        int i = RANDOM.nextInt(200);
        System.out.println("sleep " + i + " ms");
        Thread.sleep(i);
        return personMap.values();
    }


    public Collection<Person> fallbackFindAll() {
        System.out.println("=============熔断了=============");
        return Collections.EMPTY_LIST;
    }


}
