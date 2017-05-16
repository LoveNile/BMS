package com.bms.po;

import java.util.Date;

public class Borrow {
    private Integer borrowid;

    private Integer bookid;

    private Integer userid;

    private Date borrowdate;

    private Integer borrowday;

    private Integer isreturn;

    private Date returntime;

    private Boolean isrenew;

    private Integer allowborrow;

    private Integer allowback;

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

    public Integer getIsreturn() {
        return isreturn;
    }

    public void setIsreturn(Integer isreturn) {
        this.isreturn = isreturn;
    }

    public Date getReturntime() {
        return returntime;
    }

    public void setReturntime(Date returntime) {
        this.returntime = returntime;
    }

    public Boolean getIsrenew() {
        return isrenew;
    }

    public void setIsrenew(Boolean isrenew) {
        this.isrenew = isrenew;
    }

    public Integer getAllowborrow() {
        return allowborrow;
    }

    public void setAllowborrow(Integer allowborrow) {
        this.allowborrow = allowborrow;
    }

    public Integer getAllowback() {
        return allowback;
    }

    public void setAllowback(Integer allowback) {
        this.allowback = allowback;
    }
}