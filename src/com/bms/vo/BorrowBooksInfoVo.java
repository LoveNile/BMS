package com.bms.vo;

import java.util.Date;
import java.util.List;

public class BorrowBooksInfoVo {

    private List<CategoryCustom> listCategoryCustom;
    private List<BorrowCustom> listBorrowCustom;
    private PageSetVo pageSetVo;
    private Date startTime;
    private Date endTime;
    private String keyWord;
    private String category;
    private int userid;
    private Integer isreturn;

    public List<BorrowCustom> getListBorrowCustom() {
        return listBorrowCustom;
    }
    public void setListBorrowCustom(List<BorrowCustom> listBorrowCustom) {
        this.listBorrowCustom = listBorrowCustom;
    }
    public List<CategoryCustom> getListCategoryCustom() {
        return listCategoryCustom;
    }
    public void setListCategoryCustom(List<CategoryCustom> listCategoryCustom) {
        this.listCategoryCustom = listCategoryCustom;
    }
    public PageSetVo getPageSetVo() {
        return pageSetVo;
    }
    public void setPageSetVo(PageSetVo pageSetVo) {
        this.pageSetVo = pageSetVo;
    }
    public Date getStartTime() {
        return startTime;
    }
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    public Date getEndTime() {
        return endTime;
    }
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    public String getKeyWord() {
        return keyWord;
    }
    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public int getUserid() {
        return userid;
    }
    public void setUserid(int userid) {
        this.userid = userid;
    }
    public Integer getIsreturn() {
        return isreturn;
    }
    public void setIsreturn(Integer isreturn) {
        this.isreturn = isreturn;
    }


}
