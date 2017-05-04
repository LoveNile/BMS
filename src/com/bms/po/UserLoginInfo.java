package com.bms.po;

public class UserLoginInfo {

    private boolean userlegal;
    public boolean isUserlegal() {
        return userlegal;
    }
    public void setUserlegal(boolean userlegal) {
        this.userlegal = userlegal;
    }
    public String getLoginMessage() {
        return loginMessage;
    }
    public void setLoginMessage(String loginMessage) {
        this.loginMessage = loginMessage;
    }
    private String loginMessage;
}
