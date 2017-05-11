package com.bms.mapper;

import java.util.List;

import com.bms.vo.BorrowBooksInfoVo;
import com.bms.vo.BorrowCustom;

public interface BorrowCustomMapper {

    int countUserBorrowBooks(int userid);
    List<BorrowCustom> borrowBooksAllInfo(BorrowBooksInfoVo borrowBooksInfoVo);
    int countBorrowBooksAllInfo(BorrowBooksInfoVo borrowBooksInfoVo);
    int countUserRenewbook(int borrowid);
    int updateBorrowStatus(int borrowid);
    BorrowCustom getBorrowBooksDetailInfo(int borrowid);
    BorrowCustom getHistoryDetail(int borrowid);
}
