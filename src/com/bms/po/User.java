package com.bms.po;

import java.util.Date;

public class User {
    private Integer userid;

    private String username;

    private String password;

    private Boolean gender;

    private String phone;

    private String email;

    private Date birthday;

    private Date registertime;

    private String picpath;

    private Boolean status;

    private Boolean delmaker;

    private Long studentnumber;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getRegistertime() {
        return registertime;
    }

    public void setRegistertime(Date registertime) {
        this.registertime = registertime;
    }

    public String getPicpath() {
        return picpath;
    }

    public void setPicpath(String picpath) {
        this.picpath = picpath == null ? null : picpath.trim();
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getDelmaker() {
        return delmaker;
    }

    public void setDelmaker(Boolean delmaker) {
        this.delmaker = delmaker;
    }

    public Long getStudentnumber() {
        return studentnumber;
    }

    public void setStudentnumber(Long studentnumber) {
        this.studentnumber = studentnumber;
    }
}