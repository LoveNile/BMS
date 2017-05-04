package com.bms.po;

import java.util.Date;

public class BookRenew {
    private Integer bookrenewid;

    private Integer borrowid;

    private Integer renewday;

    private Date renewdate;

    public Integer getBookrenewid() {
        return bookrenewid;
    }

    public void setBookrenewid(Integer bookrenewid) {
        this.bookrenewid = bookrenewid;
    }

    public Integer getBorrowid() {
        return borrowid;
    }

    public void setBorrowid(Integer borrowid) {
        this.borrowid = borrowid;
    }

    public Integer getRenewday() {
        return renewday;
    }

    public void setRenewday(Integer renewday) {
        this.renewday = renewday;
    }

    public Date getRenewdate() {
        return renewdate;
    }

    public void setRenewdate(Date renewdate) {
        this.renewdate = renewdate;
    }
}