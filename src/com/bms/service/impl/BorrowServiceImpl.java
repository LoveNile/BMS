package com.bms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bms.exception.BorrowBookException;
import com.bms.mapper.BookStockCustomMapper;
import com.bms.mapper.BookStockMapper;
import com.bms.mapper.BorrowMapper;
import com.bms.po.BookStock;
import com.bms.po.Borrow;
import com.bms.po.BorrowExample;
import com.bms.po.BorrowExample.Criteria;
import com.bms.service.BorrowService;
import com.bms.util.DateUtil;

@Transactional
public class BorrowServiceImpl implements BorrowService {

    @Autowired
    private BorrowMapper borrowMapper;
    @Autowired
    private BookStockMapper bookStockMapper;
    @Autowired
    private BookStockCustomMapper bookStockCustomMapper;

    @Override
    public boolean userBorrowBookById(String bookid,String userid) {
        BorrowExample borrowExample = new BorrowExample();
        Criteria criteria = borrowExample.createCriteria();
        int borrowbookid = Integer.parseInt(bookid);
        int borrowuserid = Integer.parseInt(userid);
        criteria.andBookidEqualTo(borrowbookid);
        criteria.andUseridEqualTo(borrowuserid);
        criteria.andIsreturnEqualTo(false);
        List<Borrow> borrows = borrowMapper.selectByExample(borrowExample);
        if (!borrows.isEmpty()) {
            throw new BorrowBookException("已经借阅此图书，未归还！");
        }
        BookStock bookstock = bookStockMapper.selectByPrimaryKey(borrowbookid);
        if (bookstock == null || bookstock.getBooknumber() == 0) {
            throw new BorrowBookException("此图书已经被借阅完！");
        }
        Borrow borrow = new Borrow();
        borrow.setBookid(borrowbookid);
        borrow.setUserid(borrowuserid);
        borrow.setBorrowdate(DateUtil.getNowDate());
        borrow.setBorrowday(14);
        borrow.setIsreturn(false);
        borrow.setIsrenew(false);
        int borrowResult = borrowMapper.insert(borrow);
        int updateStock = bookStockCustomMapper.ChangebookStockById(borrowbookid);
        if (borrowResult ==0 || updateStock == 0) {
            throw new BorrowBookException("借阅失败，请联系管理员！");
        }
        return true;
    }

}
