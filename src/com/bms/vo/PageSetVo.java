package com.bms.vo;

public class PageSetVo {
    private int pageCount;//总页数
    private int totalCount;//总记录数
    private int currentPage;//当前页
    private int pageValue;//分页值 6
    private int pageOffset;//偏移 1

    public int getTotalcount() {
        return totalCount;
    }
    public void setTotalcount(int totalcount) {
        this.totalCount = totalcount;
        getPageoffset();
    }
    public int getPagecount() {
        if (totalCount < 1) {
            pageCount = 0;
            return  pageCount;
        }
       if (getTotalcount() % getPagevalue() == 0) {
        return getTotalcount()/getPagevalue();
    }else {
        return getTotalcount()/getPagevalue()+1;
    }

    }
    public int getCurrentpage() {
        return currentPage;
    }
    public void setCurrentpage(int currentpage) {
        this.currentPage = currentpage;
    }
    public int getPagevalue() {
        return pageValue;
    }
    public void setPagevalue(int pagevalue) {
        this.pageValue = pagevalue;
    }
    public int getPageoffset() {
        pageOffset = (getCurrentpage() - 1) * getPagevalue();
        return pageOffset;
    }
}
