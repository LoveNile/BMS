package com.bms.mapper;

import java.util.List;

import com.bms.po.User;

public interface UserCustomMapper {

    int verifyUsername(User user);
    int verifyStudent(User user);
    int verifyUserEmail(User user);
    List<User> getAllUser();
}
