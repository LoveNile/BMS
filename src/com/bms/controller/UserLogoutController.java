package com.bms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bms.Constants;

@Controller
@RequestMapping("/user")
public class UserLogoutController extends BaseController {

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String userLogout() {
        this.removeSession(Constants.BMS_CONTEXT_USER);
        this.invalidateSession();
        return "/login";
    }
}
