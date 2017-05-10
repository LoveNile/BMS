package com.bms.vo;

import com.bms.po.Borrow;

public class BorrowCustom extends Borrow {

    private String bookname;
    private String bookauthor;
    private String bookpicpath;
    private Integer renewday;

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
