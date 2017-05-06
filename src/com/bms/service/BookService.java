package com.bms.service;

import com.bms.vo.BookCustom;
import com.bms.vo.BookQueryVo;

public interface BookService {

    void getBookInfoList(BookQueryVo bookQueryVo);
    BookCustom getBookInfo(String bookid);
}
