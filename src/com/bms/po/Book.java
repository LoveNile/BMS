package com.bms.po;

import java.util.Date;

public class Book {
    private Long bookid;

    private String bookname;

    private String bookauthor;

    private Integer categoryid;

    private String bookpress;

    private Date publisheddate;

    private Date bookentertime;

    private String bookintroduction;

    private String bookaddress;

    private String bookpicpath;

    private Boolean delmaker;

    public Long getBookid() {
        return bookid;
    }

    public void setBookid(Long bookid) {
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname == null ? null : bookname.trim();
    }

    public String getBookauthor() {
        return bookauthor;
    }

    public void setBookauthor(String bookauthor) {
        this.bookauthor = bookauthor == null ? null : bookauthor.trim();
    }

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public String getBookpress() {
        return bookpress;
    }

    public void setBookpress(String bookpress) {
        this.bookpress = bookpress == null ? null : bookpress.trim();
    }

    public Date getPublisheddate() {
        return publisheddate;
    }

    public void setPublisheddate(Date publisheddate) {
        this.publisheddate = publisheddate;
    }

    public Date getBookentertime() {
        return bookentertime;
    }

    public void setBookentertime(Date bookentertime) {
        this.bookentertime = bookentertime;
    }

    public String getBookintroduction() {
        return bookintroduction;
    }

    public void setBookintroduction(String bookintroduction) {
        this.bookintroduction = bookintroduction == null ? null : bookintroduction.trim();
    }

    public String getBookaddress() {
        return bookaddress;
    }

    public void setBookaddress(String bookaddress) {
        this.bookaddress = bookaddress == null ? null : bookaddress.trim();
    }

    public String getBookpicpath() {
        return bookpicpath;
    }

    public void setBookpicpath(String bookpicpath) {
        this.bookpicpath = bookpicpath == null ? null : bookpicpath.trim();
    }

    public Boolean getDelmaker() {
        return delmaker;
    }

    public void setDelmaker(Boolean delmaker) {
        this.delmaker = delmaker;
    }
}