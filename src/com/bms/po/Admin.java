package com.bms.po;

import java.util.Date;

public class Admin {
    private Integer adminid;

    private String adminname;

    private String adminpassword;

    private Boolean admingender;

    private String adminemail;

    private String adminphone;

    private String admincard;

    private String adminaddress;

    private String adminremarks;

    private Date adminregistertime;

    public Integer getAdminid() {
        return adminid;
    }

    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname == null ? null : adminname.trim();
    }

    public String getAdminpassword() {
        return adminpassword;
    }

    public void setAdminpassword(String adminpassword) {
        this.adminpassword = adminpassword == null ? null : adminpassword.trim();
    }

    public Boolean getAdmingender() {
        return admingender;
    }

    public void setAdmingender(Boolean admingender) {
        this.admingender = admingender;
    }

    public String getAdminemail() {
        return adminemail;
    }

    public void setAdminemail(String adminemail) {
        this.adminemail = adminemail == null ? null : adminemail.trim();
    }

    public String getAdminphone() {
        return adminphone;
    }

    public void setAdminphone(String adminphone) {
        this.adminphone = adminphone == null ? null : adminphone.trim();
    }

    public String getAdmincard() {
        return admincard;
    }

    public void setAdmincard(String admincard) {
        this.admincard = admincard == null ? null : admincard.trim();
    }

    public String getAdminaddress() {
        return adminaddress;
    }

    public void setAdminaddress(String adminaddress) {
        this.adminaddress = adminaddress == null ? null : adminaddress.trim();
    }

    public String getAdminremarks() {
        return adminremarks;
    }

    public void setAdminremarks(String adminremarks) {
        this.adminremarks = adminremarks == null ? null : adminremarks.trim();
    }

    public Date getAdminregistertime() {
        return adminregistertime;
    }

    public void setAdminregistertime(Date adminregistertime) {
        this.adminregistertime = adminregistertime;
    }
}