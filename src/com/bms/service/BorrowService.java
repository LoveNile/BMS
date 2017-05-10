package com.bms.service;

import com.bms.vo.BorrowBooksInfoVo;

public interface BorrowService {

    boolean userBorrowBookById(String bookid,String userid);
    void getUserBorrowBooksInfo(BorrowBooksInfoVo borrowBooksInfoVo);
}
