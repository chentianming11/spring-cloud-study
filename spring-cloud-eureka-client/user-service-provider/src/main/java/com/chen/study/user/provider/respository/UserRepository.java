package com.chen.study.user.provider.respository;

import com.chen.study.user.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author 陈添明
 */
@Repository
public class UserRepository {


    private ConcurrentMap<Long, User> repository = new ConcurrentHashMap<>();


    private static final AtomicLong ID_GENERATOR = new AtomicLong(0);

    public boolean save(User user) {
        long id = ID_GENERATOR.incrementAndGet();
        user.setId(id);
        User absent = repository.putIfAbsent(id, user);
        return absent == null;
    }

    public Collection<User> findAll() {
        return repository.values();
    }
}
