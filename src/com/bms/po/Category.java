package com.bms.po;

import java.util.Date;

public class Category {
    private Integer categoryid;

    private String categoryname;

    private Date categorycreatetime;

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname == null ? null : categoryname.trim();
    }

    public Date getCategorycreatetime() {
        return categorycreatetime;
    }

    public void setCategorycreatetime(Date categorycreatetime) {
        this.categorycreatetime = categorycreatetime;
    }
}