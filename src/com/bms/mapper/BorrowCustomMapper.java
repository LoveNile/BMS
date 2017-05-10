package com.bms.mapper;

import java.util.List;

import com.bms.vo.BorrowBooksInfoVo;
import com.bms.vo.BorrowCustom;

public interface BorrowCustomMapper {

    int CountUserBorrowBooks(int userid);
    List<BorrowCustom> BorrowBooksAllInfo(BorrowBooksInfoVo borrowBooksInfoVo);
    int CountBorrowBooksAllInfo(BorrowBooksInfoVo borrowBooksInfoVo);
}
