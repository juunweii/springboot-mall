package com.walton.springbootmall.dao;

import com.walton.springbootmall.dto.UserRegisterRequest;
import com.walton.springbootmall.model.User;

/**
 * @author Walton Hung (chunweih@andrew.cmu.edu)
 */
public interface UserDao {

    User getUserById(Integer userId);
    Integer createUser(UserRegisterRequest userRegisterRequest);

}
