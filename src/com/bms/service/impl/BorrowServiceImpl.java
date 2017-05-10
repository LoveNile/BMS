package com.bms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bms.Constants;
import com.bms.exception.BorrowBookException;
import com.bms.mapper.BookStockCustomMapper;
import com.bms.mapper.BookStockMapper;
import com.bms.mapper.BorrowCustomMapper;
import com.bms.mapper.BorrowMapper;
import com.bms.mapper.CategoryCustomMapper;
import com.bms.po.BookStock;
import com.bms.po.Borrow;
import com.bms.po.BorrowExample;
import com.bms.po.BorrowExample.Criteria;
import com.bms.service.BorrowService;
import com.bms.util.DateUtil;
import com.bms.vo.BorrowBooksInfoVo;
import com.bms.vo.BorrowCustom;
import com.bms.vo.CategoryCustom;

@Transactional
public class BorrowServiceImpl implements BorrowService {

    @Autowired
    private BorrowMapper borrowMapper;
    @Autowired
    private BookStockMapper bookStockMapper;
    @Autowired
    private BookStockCustomMapper bookStockCustomMapper;
    @Autowired
    private BorrowCustomMapper borrowCustomMapper;
    @Autowired
    private CategoryCustomMapper categoryCustomMapper;

    @Override
    public boolean userBorrowBookById(String bookid,String userid) {
        int borrowuserid = Integer.parseInt(userid);
        if (borrowCustomMapper.CountUserBorrowBooks(borrowuserid) < 10) {
            BorrowExample borrowExample = new BorrowExample();
            Criteria criteria = borrowExample.createCriteria();
            int borrowbookid = Integer.parseInt(bookid);
            criteria.andBookidEqualTo(borrowbookid);
            criteria.andUseridEqualTo(borrowuserid);
            criteria.andIsreturnEqualTo(false);
            List<Borrow> borrows = borrowMapper.selectByExample(borrowExample);
            if (!borrows.isEmpty()) {
                throw new BorrowBookException(Constants.BMS_BORROW_NORETURN);
            }
            BookStock bookstock = bookStockMapper.selectByPrimaryKey(borrowbookid);
            if (bookstock == null || bookstock.getBooknumber() == 0) {
                throw new BorrowBookException(Constants.BMS_BORROW_NOSTOCK);
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
            if (borrowResult == 0 || updateStock == 0) {
                throw new BorrowBookException(Constants.BMS_BORROW_BACKGROUNDERROE);
            }
        } else {
            throw new BorrowBookException(Constants.BMS_BORROW_MOREBOOKS);
        }
        return true;
    }

    @Override
    public void getUserBorrowBooksInfo(BorrowBooksInfoVo borrowBooksInfoVo) {
        int countborrow = borrowCustomMapper.CountBorrowBooksAllInfo(borrowBooksInfoVo);
        borrowBooksInfoVo.getPageSetVo().setTotalcount(countborrow);
        List<BorrowCustom> listBorrowCusto = borrowCustomMapper.BorrowBooksAllInfo(borrowBooksInfoVo);
        borrowBooksInfoVo.setListBorrowCustom(listBorrowCusto);
        List<CategoryCustom> listCategoryCustom = categoryCustomMapper.getAllCategory();
        borrowBooksInfoVo.setListCategoryCustom(listCategoryCustom);
    }

}
