package com.bms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bms.Constants;
import com.bms.exception.BorrowBookException;
import com.bms.mapper.BookRenewMapper;
import com.bms.mapper.BookStockCustomMapper;
import com.bms.mapper.BookStockMapper;
import com.bms.mapper.BorrowCustomMapper;
import com.bms.mapper.BorrowMapper;
import com.bms.mapper.CategoryCustomMapper;
import com.bms.mapper.StudentMapper;
import com.bms.po.BookRenew;
import com.bms.po.BookStock;
import com.bms.po.Borrow;
import com.bms.po.BorrowExample;
import com.bms.po.BorrowExample.Criteria;
import com.bms.service.BorrowService;
import com.bms.util.DateUtil;
import com.bms.vo.BorrowBooksDetailInfoVo;
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
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private BookRenewMapper bookRenewMapper;

    @Override
    public boolean userBorrowBookById(String bookid,String userid,Long studentnumber) {
        int borrowuserid = Integer.parseInt(userid);
        if (studentMapper.selectByPrimaryKey(studentnumber).getStudentstatus()) {
            if (borrowCustomMapper.countUserBorrowBooks(borrowuserid) < 10) {
                BorrowExample borrowExample = new BorrowExample();
                Criteria criteria = borrowExample.createCriteria();
                int borrowbookid = Integer.parseInt(bookid);
                criteria.andBookidEqualTo(borrowbookid);
                criteria.andUseridEqualTo(borrowuserid);
                criteria.andIsreturnNotEqualTo(1);
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
                borrow.setIsreturn(2);
                borrow.setIsrenew(false);
                int borrowResult = borrowMapper.insert(borrow);
                int updateStock = bookStockCustomMapper.ChangebookStockById(borrowbookid);
                if (borrowResult == 0 || updateStock == 0) {
                    throw new BorrowBookException(Constants.BMS_BORROW_BACKGROUNDERROE);
                }
            } else {
                throw new BorrowBookException(Constants.BMS_BORROW_MOREBOOKS);
            }
        } else {
            throw new BorrowBookException(Constants.BMS_BORROW_STUDENT_ERROR);
        }

        return true;
    }

    @Override
    public void getUserBorrowBooksInfo(BorrowBooksInfoVo borrowBooksInfoVo) {
        int countborrow = borrowCustomMapper.countBorrowBooksAllInfo(borrowBooksInfoVo);
        borrowBooksInfoVo.getPageSetVo().setTotalcount(countborrow);
        List<BorrowCustom> listBorrowCusto = borrowCustomMapper.borrowBooksAllInfo(borrowBooksInfoVo);
        borrowBooksInfoVo.setListBorrowCustom(listBorrowCusto);
        List<CategoryCustom> listCategoryCustom = categoryCustomMapper.getAllCategory();
        borrowBooksInfoVo.setListCategoryCustom(listCategoryCustom);
    }

    @Override
    public boolean userRenewBorrowBook(String borrowid) {
        int renewborrowid = Integer.parseInt(borrowid);
        int renewcount = borrowCustomMapper.countUserRenewbook(renewborrowid);
        if (renewcount == 0) {
            borrowCustomMapper.updateBorrowStatus(renewborrowid);
        }
        if (!(renewcount > 3) ) {
            BookRenew bookRenew = new BookRenew();
            bookRenew.setBorrowid(renewborrowid);
            bookRenew.setRenewdate(DateUtil.getNowDate());
            bookRenew.setRenewday(3);
            int count = bookRenewMapper.insert(bookRenew);
            if (count == 0) {
                throw new BorrowBookException("续借失败，请联系管理员！");
            }
        } else {
            throw new BorrowBookException("续借超过次数！");
        }
        return true;
    }

    @Override
    public boolean userbackBorrowBook(String borrowid) {
        int backbook = Integer.parseInt(borrowid);
        Borrow borrowinfo = borrowMapper.selectByPrimaryKey(backbook);
        borrowinfo.setReturntime(DateUtil.getNowDate());
        borrowinfo.setIsreturn(0);
        int result = borrowMapper.updateByPrimaryKey(borrowinfo);
        if (result == 0) {
            throw new BorrowBookException("还书失败，请联系管理员！");
        }
        return true;
    }

    @Override
    public BorrowBooksDetailInfoVo getBorrowBooksInfoById(String borrowid) {
        int detaiborrowid = Integer.parseInt(borrowid);
        BorrowCustom borrowCustom = borrowCustomMapper.getBorrowBooksDetailInfo(detaiborrowid);
        BorrowBooksDetailInfoVo borrowBooksDetailInfoVo = new BorrowBooksDetailInfoVo();
        borrowCustom.setCountrenewday(borrowCustomMapper.countUserRenewbook(detaiborrowid));
        borrowBooksDetailInfoVo.setBorrowCustom(borrowCustom);
        return borrowBooksDetailInfoVo;

    }

    @Override
    public BorrowBooksDetailInfoVo getHistoryBorrowinfo(String borrowid) {
        int historydetaiborrowid = Integer.parseInt(borrowid);
        BorrowCustom borrowCustom = borrowCustomMapper.getHistoryDetail(historydetaiborrowid);
        BorrowBooksDetailInfoVo borrowBooksDetailInfoVo = new BorrowBooksDetailInfoVo();
        borrowCustom.setCountrenewday(borrowCustomMapper.countUserRenewbook(historydetaiborrowid));
        borrowBooksDetailInfoVo.setBorrowCustom(borrowCustom);
        return borrowBooksDetailInfoVo;
    }

}
