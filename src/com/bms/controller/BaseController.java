package com.bms.controller;

import org.springframework.web.servlet.view.RedirectView;

import com.bms.BMSContext;
import com.bms.po.User;
import com.bms.util.SessionUtil;

public class BaseController {

    protected User getUser() {
        return BMSContext.getBMSContext().getUser();
    }

    public String getUserName() {
        User user = getUser();
        if (user != null) {
            return user.getUsername();
        }
        return "";
    }

    public boolean isHaveStudentNumber(){
        User user = getUser();
        if (user.getStudentnumber() == null) {
            return false;
        }
        return true;
    }

    public long getStudentNumber(){
        User user = getUser();
        return user.getStudentnumber();
    }
    public String getUserId() {
        User user = getUser();
        if (user != null) {
            return user.getUserid().toString();
        }
        return "";
    }

    protected RedirectView getRedirectView(String path) {
        return new RedirectView(path);
    }

    protected void addSession(String key,Object object) {
        SessionUtil.addSession(key, object);
    }

    protected Object getSession(String key) {
        return SessionUtil.getSession(key);
    }

    protected void removeSession(String key) {
        SessionUtil.removeSession(key);
    }

    protected void invalidateSession() {
        SessionUtil.invalidateSession();
    }
}
