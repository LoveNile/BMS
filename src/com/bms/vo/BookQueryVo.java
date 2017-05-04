package com.bms.vo;

import java.util.Date;
import java.util.List;

public class BookQueryVo {

    private List<CategoryCustom> listCategoryCustom;
    private List<BookCustom> listBookCustom;
    private PageSetVo pageSetVo;
    private Date startTime;
    private Date endTime;
    private String keyWord;

    public List<BookCustom> getListBookCustom() {
        return listBookCustom;
    }

    public void setListBookCustom(List<BookCustom> listBookCustom) {
        this.listBookCustom = listBookCustom;
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

}
