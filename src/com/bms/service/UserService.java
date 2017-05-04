package com.bms.service;

import com.bms.po.User;

public interface UserService {

    User getUserInfo(String username,String password);

    boolean userRegister(String registerUsername,String registerEmail,String registerPassword);

    String userForgetPassword(String username);

    boolean userActivation(String userName);

    boolean updatePassword(String password);
}
