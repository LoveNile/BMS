package com.bms.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bms.Constants;
import com.bms.exception.LoginErrorException;
import com.bms.po.Admin;
import com.bms.service.AdminService;

@Controller
@RequestMapping(value="/admin")
public class AdminLoginController extends BaseController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String adminLogin(){
        return "admin";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> adminLogin(@RequestParam(value = "adminname")String adminname,
            @RequestParam(value="adminpassword")String password){
        Map<String, Object> adminMap = new HashMap<String, Object>();
        try {
            Admin admin = adminService.adminToLogin(adminname, password);
            adminMap.put("adminresult", true);
            this.addSession(Constants.BMS_ADMIN, admin);
        } catch (LoginErrorException e) {
            adminMap.put("adminresult", false);
            adminMap.put("adminmsg", e.getMessage());
        }
        return adminMap;
    }
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String adminLogout(){
        this.removeSession(Constants.BMS_ADMIN);
        return "admin";
    }
}
