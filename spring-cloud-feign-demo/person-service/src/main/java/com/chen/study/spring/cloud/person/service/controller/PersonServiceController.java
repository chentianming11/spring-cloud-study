package com.chen.study.spring.cloud.person.service.controller;

import com.chen.study.spring.could.api.domain.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * PersonService 实现
 * 可选实现 PersonService 接口
 * @author 陈添明
 */
@RestController
public class PersonServiceController {

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
    public Collection<Person> findAll() {
        return personMap.values();
    }
}
