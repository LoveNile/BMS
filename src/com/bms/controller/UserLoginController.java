package com.bms.controller;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bms.BMSContext;
import com.bms.Constants;
import com.bms.exception.ActivationErrorException;
import com.bms.exception.ForgetPasswordException;
import com.bms.exception.LoginErrorException;
import com.bms.exception.RegisterException;
import com.bms.po.User;
import com.bms.service.UserService;

@Controller
@RequestMapping("/user")
public class UserLoginController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView userLogin() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/login");
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> verifyUser(@RequestParam(value = "username",defaultValue = "") String username,
            @RequestParam(value = "password", defaultValue = "") String password) {
        Map<String, Object> loginInfo = new HashMap<String, Object>();
        try {
            User user = userService.getUserInfo(username,password);
            this.addSession(Constants.BMS_CONTEXT_USER, user);
            loginInfo.put("UserLegal", true);
            loginInfo.put("LoginMessage", BMSContext.getContextPath() + "/book/bookshow");
        }
        catch (LoginErrorException e) {
            loginInfo.put("UserLegal", false);
            loginInfo.put("LoginMessage", e.getMessage());
        }
        return loginInfo;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> userRegister(@RequestParam(value = "registerusername", defaultValue = "") String registerUsername,
            @RequestParam(value = "registeremail", defaultValue = "") String registerEmail,
            @RequestParam(value = "registerpassword",defaultValue = "") String registerPassword) {
        Map<String, Object> registerInfo = new HashMap<String, Object>();
        try {
            userService.userRegister(registerUsername, registerEmail, registerPassword);
            registerInfo.put("RegisterResult", true);
            registerInfo.put("RegisterMsg", Constants.BMS_REGISTER_SUCCESS);
        }
        catch (RegisterException e) {
            registerInfo.put("RegisterResult", false);
            registerInfo.put("RegisterMsg", e.getMessage());
        }
        return registerInfo;
    }

    @RequestMapping(value = "/activation/{id}", method = RequestMethod.GET)
    public ModelAndView userActivation(@PathVariable String id){
        ModelAndView modelAndView = new ModelAndView();
        try {
            userService.userActivation("5");
            modelAndView.addObject("activationMsg", Constants.BMS_ACTIVATION_SUCCESS);
        }
        catch (ActivationErrorException e) {
            modelAndView.addObject("activationMsg", e.getMessage());
        }
        modelAndView.setViewName("/activation");
        return modelAndView;
    }

    @RequestMapping(value = "/forget", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> userForgetPassword(@RequestParam(value = "username", defaultValue ="") String username) {
        Map<String, Object> fogetInfo = new HashMap<String, Object>();
        try {
            String userEmail = userService.userForgetPassword(username);
            fogetInfo.put("ForgetResult", true);
            fogetInfo.put("ForgetMsg", MessageFormat.format(Constants.BMS_FORGET_SUCCESS, userEmail));
        }
        catch (ForgetPasswordException e) {
            fogetInfo.put("ForgetResult", false);
            fogetInfo.put("ForgetMsg", e.getMessage());
        }
        return fogetInfo;
    }

    @RequestMapping(value = "/verify", method = RequestMethod.POST)
    @ResponseBody
    public boolean contrastVerificationCode(@RequestParam(value = "verificationcode", defaultValue ="") String verificationcode){
        if (this.getSession("verificationcode").equals(verificationcode)) {
            return true;
        }
        return false;
    }

    @RequestMapping(value = "/updatepassword", method = RequestMethod.POST)
    @ResponseBody
    public boolean updateUserPassword(@RequestParam(value = "password", defaultValue ="") String password) {
        if(userService.updatePassword(password)) {
            return true;
        }
        return false;
    }
}
