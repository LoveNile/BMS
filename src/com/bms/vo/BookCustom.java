package com.bms.vo;

import com.bms.po.Book;

public class BookCustom extends Book {
    private Integer booknumber;

    public Integer getBooknumber() {
        return booknumber;
    }

    public void setBooknumber(Integer booknumber) {
        this.booknumber = booknumber;
    }
}
