package com.brucer.service.impl;


import com.brucer.dao.UserRepository;
import com.brucer.domain.User;
import com.brucer.service.UserService;
import com.brucer.utils.MD5Utils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private  UserRepository userRepository;


    /**
     * 用户查找
     * @param username
     * @param password
     * @return
     */
    @Override
    public User checkUser(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }
}
