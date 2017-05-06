package com.bms.mapper;

import java.util.List;

import com.bms.vo.BookCustom;
import com.bms.vo.BookQueryVo;

public interface BookInfoMapper {

    List<BookCustom> getBookInfo(BookQueryVo bookQueryVo);

    int getCountBook(BookQueryVo bookQueryVo);
    BookCustom getDetailBookInfo(int bookid);
}
