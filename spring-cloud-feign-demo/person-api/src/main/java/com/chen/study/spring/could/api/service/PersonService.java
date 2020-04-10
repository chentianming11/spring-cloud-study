package com.chen.study.spring.could.api.service;

import com.chen.study.spring.could.api.domain.Person;
import com.chen.study.spring.could.api.hystrix.PersonServiceFallBack;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;

/**
 * person-service: 服务提供方应用的名称
 *
 * @author 陈添明
 */
@FeignClient(value = "person-service", fallback = PersonServiceFallBack.class)
public interface PersonService {


    /**
     * .
     *
     * @param person .
     * @return .
     */
    @PostMapping(value = "/person/save")
    boolean save(@RequestBody Person person);

    /**
     * .
     *
     * @return .
     */
    @GetMapping("/person/findAll")
    Collection<Person> findAll();
}
