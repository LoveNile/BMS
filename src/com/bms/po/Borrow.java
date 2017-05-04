package com.bms.po;

import java.util.Date;

public class Borrow {
    private Integer borrowid;

    private Integer bookid;

    private Integer userid;

    private Date borrowdate;

    private Integer borrowday;

    private Boolean isreturn;

    private Date returntime;

    public Integer getBorrowid() {
        return borrowid;
    }

    public void setBorrowid(Integer borrowid) {
        this.borrowid = borrowid;
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getBorrowdate() {
        return borrowdate;
    }

    public void setBorrowdate(Date borrowdate) {
        this.borrowdate = borrowdate;
    }

    public Integer getBorrowday() {
        return borrowday;
    }

    public void setBorrowday(Integer borrowday) {
        this.borrowday = borrowday;
    }

    public Boolean getIsreturn() {
        return isreturn;
    }

    public void setIsreturn(Boolean isreturn) {
        this.isreturn = isreturn;
    }

    public Date getReturntime() {
        return returntime;
    }

    public void setReturntime(Date returntime) {
        this.returntime = returntime;
    }
}