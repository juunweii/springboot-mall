package com.walton.springbootmall.service;

import com.walton.springbootmall.dto.UserRegisterRequest;
import com.walton.springbootmall.model.User;

/**
 * @author Walton Hung (chunweih@andrew.cmu.edu)
 */
public interface UserService {

    User getUserById(Integer userId);
    Integer register(UserRegisterRequest userRegisterRequest);
}
