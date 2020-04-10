package com.chen.study.spring.could.api.hystrix;

import com.chen.study.spring.could.api.domain.Person;
import com.chen.study.spring.could.api.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

/**
 * @author 陈添明
 */
@Service
public class PersonServiceFallBack implements PersonService {
    /**
     * .
     *
     * @param person .
     * @return .
     */
    @Override
    public boolean save(Person person) {
        return false;
    }

    /**
     * .
     *
     * @return .
     */
    @Override
    public Collection<Person> findAll() {
        return Collections.EMPTY_LIST;
    }
}
