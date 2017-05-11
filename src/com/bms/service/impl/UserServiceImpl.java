package com.bms.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bms.Constants;
import com.bms.exception.ActivationErrorException;
import com.bms.exception.ForgetPasswordException;
import com.bms.exception.LoginErrorException;
import com.bms.exception.RegisterException;
import com.bms.mapper.StudentMapper;
import com.bms.mapper.UserMapper;
import com.bms.po.Student;
import com.bms.po.User;
import com.bms.po.UserExample;
import com.bms.po.UserExample.Criteria;
import com.bms.service.UserService;
import com.bms.util.JMailUtil;
import com.bms.util.MD5Util;
import com.bms.util.MathRandomUtil;
import com.bms.util.SessionUtil;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public User getUserInfo(String username, String password) {
        UserExample userExample = new UserExample();
        Criteria usernameCriteria = userExample.createCriteria();
        usernameCriteria.andUsernameEqualTo(username);
        usernameCriteria.andDelmakerEqualTo(false);
        Criteria emailCriteria = userExample.createCriteria();
        emailCriteria.andEmailEqualTo(username);
        emailCriteria.andDelmakerEqualTo(false);
        userExample.or(emailCriteria);
        List<User> userList = userMapper.selectByExample(userExample);
        if (userList.isEmpty()) {
            throw new LoginErrorException(Constants.BMS_ACCOUNT_ERROR);
        }
        User user = userList.get(0);
        if (!user.getStatus()) {
            throw new LoginErrorException(Constants.BMS_ACCOUNT_STATUS);
        }
        if (!user.getPassword().equals(MD5Util.encodeByMD5(password))) {
            throw new LoginErrorException(Constants.BMS_PASSWORD_ERROR);
        }
        return user;
    }

    @Override
    public boolean userRegister(String registerUsername, String registerEmail,
            String registerPassword) {
        String errorMessage = "";
        UserExample usernameExample = new UserExample();
        usernameExample.or().andUsernameEqualTo(registerUsername);
        int countUsername = userMapper.countByExample(usernameExample);
        UserExample emailExample = new UserExample();
        emailExample.or().andEmailEqualTo(registerEmail);
        int countEmail = userMapper.countByExample(emailExample);
        if (countUsername > 0 || countEmail > 0) {
            if (countUsername > 0) {
                errorMessage = Constants.BMS_REGISTER_ERROR_USERNAME;
            }
            if (countEmail > 0) {
                errorMessage = Constants.BMS_REGISTER_ERROR_EMAIL;
            }
            if (countUsername > 0 && countEmail > 0) {
                errorMessage = Constants.BMS_REGISTER_ERROR;
            }
            throw new RegisterException(errorMessage);
        }
        User registerUser = new User();
        registerUser.setUsername(registerUsername);
        registerUser.setEmail(registerEmail);
        registerUser.setPassword(MD5Util.encodeByMD5(registerPassword));
        registerUser.setRegistertime(new Date());
        registerUser.setStatus(false);
        registerUser.setDelmaker(false);
        int register = userMapper.insert(registerUser);
        if (register == 0) {
            throw new RegisterException(Constants.BMS_REGISTER_FAIL);
        }
        try {
            User user = (User) userMapper.selectByExample(usernameExample);
            JMailUtil.BMSSendEmail(registerEmail, "BMS", "欢迎来到BMS！点此链接激活BMS账号http://localhost:8080/BMS/user/activation/"+user.getUserid());
        }
        catch (Exception e) {
            userMapper.deleteByExample(usernameExample);
            throw new RegisterException(Constants.BMS_SEND_EMAIL_ERROR);
        }
        return true;
    }

    @Override
    public String userForgetPassword(String username) {
        UserExample userExample = new UserExample();
        userExample.or().andUsernameEqualTo(username);
        List<User> listUser = userMapper.selectByExample(userExample);
        if (listUser.isEmpty()) {
            throw new ForgetPasswordException(Constants.BMS_FORGET_PASSWORD);
        }
        User user = listUser.get(0);
        String userEmail = user.getEmail();
        try {
            String verificationcode = MathRandomUtil.getMathRandom();
            JMailUtil.BMSSendEmail(userEmail, "图书管理系统找回密码", verificationcode);
            SessionUtil.addSession("userid", user.getUserid());
            SessionUtil.addSession("verificationcode", verificationcode);
        }
        catch (Exception e) {
            throw new ForgetPasswordException(Constants.BMS_SEND_EMAIL_ERROR);
        }
        return userEmail;
    }

    @Override
    public boolean userActivation(String id) {
        User user = userMapper.selectByPrimaryKey(Integer.parseInt(id));
        if (user.getStatus()) {
            throw new ActivationErrorException(Constants.BMS_ACTIVATION_ERROR_TWO);
        } else {
            user.setStatus(true);
            int userStatus = userMapper.updateByPrimaryKey(user);
            if (userStatus == 0) {
                throw new ActivationErrorException(Constants.BMS_ACTIVATION_ERROR_ONE);
            }
        }
        return false;
    }

    @Override
    public boolean updatePassword(String password) {
        User user = new User();
        user.setUserid((Integer)SessionUtil.getSession("userid"));
        user.setPassword(MD5Util.encodeByMD5(password));
        int updateResult = userMapper.updateByPrimaryKeySelective(user);
        SessionUtil.removeSession("userid");
        SessionUtil.removeSession("verificationcode");
        if (updateResult == 0) {
            return false;
        }
        return true;
    }

    @Override
    public User getUserInfo(String userid) {
        return userMapper.selectByPrimaryKey(Integer.parseInt(userid));
    }

    @Override
    public Student getStudentInfoByNumber(long studentnumber) {
        return studentMapper.selectByPrimaryKey(studentnumber);
    }

}
