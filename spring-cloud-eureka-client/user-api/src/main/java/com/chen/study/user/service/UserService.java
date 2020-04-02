package com.chen.study.user.service;

import com.chen.study.user.domain.User;

import java.util.Collection;

/**
 * @author 陈添明
 */
public interface UserService {

    /**
     * 保存用户
     * @param user
     * @return 成功返回<code>true</code>, 否则返回<code>false</code>
     */
    boolean save(User user);


    /**
     * 查询所有用户
     * @return 不会返回<code>null</code>
     */
    Collection<User> findAll();
}
