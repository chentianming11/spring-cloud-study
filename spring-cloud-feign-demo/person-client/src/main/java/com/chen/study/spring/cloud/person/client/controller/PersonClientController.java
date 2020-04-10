package com.chen.study.spring.cloud.person.client.controller;

import com.chen.study.spring.could.api.domain.Person;
import com.chen.study.spring.could.api.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * 直接实现PersonService
 *
 * @author 陈添明
 */
@RestController
public class PersonClientController implements PersonService {

    @Autowired
    PersonService personService;

    /**
     * .
     *
     * @param person .
     * @return .
     */
    @Override
    public boolean save(@RequestBody Person person) {
        return personService.save(person);
    }

    /**
     * .
     *
     * @return .
     */
    @Override
    public Collection<Person> findAll() {
        return personService.findAll();
    }
}
