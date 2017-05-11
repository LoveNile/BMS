package com.bms.service;

import com.bms.po.Student;
import com.bms.po.User;

public interface UserService {

    User getUserInfo(String username,String password);

    boolean userRegister(String registerUsername,String registerEmail,String registerPassword);

    String userForgetPassword(String username);

    boolean userActivation(String id);

    boolean updatePassword(String password);

    User getUserInfo(String userid);

    Student getStudentInfoByNumber(long studentnumber);
}
