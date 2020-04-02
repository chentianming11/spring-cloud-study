package com.chen.study.user.provider.service;

import com.chen.study.user.domain.User;
import com.chen.study.user.provider.respository.UserRepository;
import com.chen.study.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author 陈添明
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    /**
     * 保存用户
     *
     * @param user
     * @return 成功返回<code>true</code>, 否则返回<code>false</code>
     */
    @Override
    public boolean save(User user) {
        return userRepository.save(user);
    }

    /**
     * 查询所有用户
     *
     * @return 不会返回<code>null</code>
     */
    @Override
    public Collection<User> findAll() {
        return userRepository.findAll();
    }
}
