package com.bms.po;

import java.util.Date;

public class AdminAction {
    private Integer adminactionid;

    private Integer adminid;

    private String adminactiontype;

    private Date adminactiontime;

    private String adminactionto;

    public Integer getAdminactionid() {
        return adminactionid;
    }

    public void setAdminactionid(Integer adminactionid) {
        this.adminactionid = adminactionid;
    }

    public Integer getAdminid() {
        return adminid;
    }

    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
    }

    public String getAdminactiontype() {
        return adminactiontype;
    }

    public void setAdminactiontype(String adminactiontype) {
        this.adminactiontype = adminactiontype == null ? null : adminactiontype.trim();
    }

    public Date getAdminactiontime() {
        return adminactiontime;
    }

    public void setAdminactiontime(Date adminactiontime) {
        this.adminactiontime = adminactiontime;
    }

    public String getAdminactionto() {
        return adminactionto;
    }

    public void setAdminactionto(String adminactionto) {
        this.adminactionto = adminactionto == null ? null : adminactionto.trim();
    }
}