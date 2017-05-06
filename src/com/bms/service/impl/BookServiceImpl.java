package com.bms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bms.mapper.BookInfoMapper;
import com.bms.mapper.CategoryCustomMapper;
import com.bms.service.BookService;
import com.bms.vo.BookCustom;
import com.bms.vo.BookQueryVo;
import com.bms.vo.CategoryCustom;

public class BookServiceImpl implements BookService {

    @Autowired
    private BookInfoMapper bookInfoMapper;
    @Autowired
    private CategoryCustomMapper categoryCustomMapper;

    @Override
    public void getBookInfoList(BookQueryVo bookQueryVo) {
        int countBook = bookInfoMapper.getCountBook(bookQueryVo);
        bookQueryVo.getPageSetVo().setTotalcount(countBook);
        if (bookQueryVo.getPageSetVo().getCurrentpage() > bookQueryVo.getPageSetVo().getPagecount()) {
            bookQueryVo.getPageSetVo().setCurrentpage(bookQueryVo.getPageSetVo().getPagecount());
        }
        List<BookCustom> listBookCustom = bookInfoMapper.getBookInfo(bookQueryVo);
        bookQueryVo.setListBookCustom(listBookCustom);
        List<CategoryCustom> listCategoryCustom = categoryCustomMapper.getAllCategory();
        bookQueryVo.setListCategoryCustom(listCategoryCustom);
    }

    @Override
    public BookCustom getBookInfo(String bookid) {
        BookCustom bookCustom = bookInfoMapper.getDetailBookInfo(Integer.parseInt(bookid));
        return bookCustom;
    }
}
