package com.bms.vo;

import com.bms.po.Borrow;

public class BorrowCustom extends Borrow {

    private String bookname;
    private String bookauthor;
    private String bookpicpath;
    private Integer renewday;
    private int countrenewday;
    private String categoryname;
    private String username;
    private String bookaddress;
    private String borrowdatalocal;

    public String getBorrowdatalocal() {
        return this.getBorrowdate().toLocaleString();
    }
    public String getBookaddress() {
        return bookaddress;
    }
    public void setBookaddress(String bookaddress) {
        this.bookaddress = bookaddress;
    }
    public String getCategoryname() {
        return categoryname;
    }
    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public int getCountrenewday() {
        return countrenewday;
    }
    public void setCountrenewday(int countrenewday) {
        this.countrenewday = countrenewday;
    }
    public String getBookname() {
        return bookname;
    }
    public void setBookname(String bookname) {
        this.bookname = bookname;
    }
    public String getBookauthor() {
        return bookauthor;
    }
    public void setBookauthor(String bookauthor) {
        this.bookauthor = bookauthor;
    }
    public String getBookpicpath() {
        return bookpicpath;
    }
    public void setBookpicpath(String bookpicpath) {
        this.bookpicpath = bookpicpath;
    }
    public Integer getRenewday() {
        return renewday;
    }
    public void setRenewday(Integer renewday) {
        this.renewday = renewday;
    }
}
