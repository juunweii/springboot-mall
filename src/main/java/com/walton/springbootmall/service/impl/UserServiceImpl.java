package com.walton.springbootmall.service.impl;

import com.walton.springbootmall.dao.UserDao;
import com.walton.springbootmall.dto.UserRegisterRequest;
import com.walton.springbootmall.model.User;
import com.walton.springbootmall.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;


/**
 * @author Walton Hung (chunweih@andrew.cmu.edu)
 */
@Component
public class UserServiceImpl implements UserService {

    private final static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        User user = userDao.getUserByEmail(userRegisterRequest.getEmail());

        //Check whether email exist
        if (user != null) {
            log.warn("email {} already exist", userRegisterRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST); //400
        }
        //Create account
        return userDao.createUser(userRegisterRequest);
    }
}
