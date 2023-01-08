package com.walton.springbootmall.service.impl;

import com.walton.springbootmall.dao.UserDao;
import com.walton.springbootmall.dto.UserRegisterRequest;
import com.walton.springbootmall.model.User;
import com.walton.springbootmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Walton Hung (chunweih@andrew.cmu.edu)
 */
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        return userDao.createUser(userRegisterRequest);
    }
}
