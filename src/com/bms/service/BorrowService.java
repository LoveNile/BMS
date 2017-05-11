package com.bms.service;

import com.bms.vo.BorrowBooksDetailInfoVo;
import com.bms.vo.BorrowBooksInfoVo;

public interface BorrowService {

    boolean userBorrowBookById(String bookid,String userid,Long studentnumber);
    void getUserBorrowBooksInfo(BorrowBooksInfoVo borrowBooksInfoVo);
    boolean userRenewBorrowBook(String borrowid);
    boolean userbackBorrowBook(String borrowid);
    BorrowBooksDetailInfoVo getBorrowBooksInfoById(String borrowid);
    BorrowBooksDetailInfoVo getHistoryBorrowinfo(String borrowid);
}
