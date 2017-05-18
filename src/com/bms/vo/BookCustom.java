package com.bms.vo;

import com.bms.po.Book;

public class BookCustom extends Book {
    private Integer booknumber;
    private String categoryname;
    private String bookpublichdate;


    public String getBookpublichdate() {
        return getPublisheddate().toLocaleString();
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public Integer getBooknumber() {
        return booknumber;
    }

    public void setBooknumber(Integer booknumber) {
        this.booknumber = booknumber;
    }

}
