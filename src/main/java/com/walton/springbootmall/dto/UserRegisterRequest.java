package com.walton.springbootmall.dto;

import javax.validation.constraints.NotBlank;

/**
 * @author Walton Hung (chunweih@andrew.cmu.edu)
 */
public class UserRegisterRequest {
    @NotBlank
    private String email;
    @NotBlank
    private String password;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
