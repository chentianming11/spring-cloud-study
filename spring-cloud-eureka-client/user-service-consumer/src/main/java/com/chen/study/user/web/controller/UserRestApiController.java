package com.chen.study.user.web.controller;

import com.chen.study.user.domain.User;
import com.chen.study.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * @author 陈添明
 */
@RestController
public class UserRestApiController {


    @Autowired
    private UserService userService;


    /**
     * .
     * @param user .
     * @return 如果保存成功，返回 user 对象，否则返回null
     */
    @PostMapping("/user/save")
    public User saveUser(@RequestBody User user) {
        if (userService.save(user)) {
            return user;
        } else {
            return null;
        }
    }


    /**
     * 返回所有用户
     * @return 返回所有用户
     */
    @GetMapping("/user/list")
    public Collection<User> list() {
        return userService.findAll();
    }

}
