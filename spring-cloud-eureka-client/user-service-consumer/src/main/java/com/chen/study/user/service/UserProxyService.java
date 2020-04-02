package com.chen.study.user.service;

import com.chen.study.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

/**
 * @author 陈添明
 */
@Service
public class UserProxyService implements UserService{

    @Autowired
    private RestTemplate restTemplate;

    private static final String PROVIDER_SERVER_URL_PREFIX = "http://user-service-provider";

    /**
     * 保存用户
     *
     * @param user
     * @return 成功返回<code>true</code>, 否则返回<code>false</code>
     */
    @Override
    public boolean save(User user) {
        User returnValue = restTemplate
                .postForObject(PROVIDER_SERVER_URL_PREFIX + "/save/user", user, User.class);
        return returnValue != null;
    }

    /**
     * 查询所有用户
     *
     * @return 不会返回<code>null</code>
     */
    @Override
    public Collection<User> findAll() {
        return restTemplate.getForObject(PROVIDER_SERVER_URL_PREFIX + "list", Collection.class);
    }
}
