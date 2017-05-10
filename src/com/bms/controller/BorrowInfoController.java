package com.bms.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bms.Constants;
import com.bms.exception.BorrowBookException;
import com.bms.service.BorrowService;
import com.bms.util.DateUtil;
import com.bms.vo.BorrowBooksInfoVo;
import com.bms.vo.PageSetVo;

@Controller
@RequestMapping(value = "/borrow")
public class BorrowInfoController extends BaseController {

    @Autowired
    private BorrowService borrowService;

    @RequestMapping(value = "/userborrow", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> userBorrowBook(@RequestParam(value = "bookid")String bookid) {
        Map<String, Object> borrowInfo = new HashMap<String, Object>();
        if (this.getStudentNumber()) {
            try {
                borrowService.userBorrowBookById(bookid, this.getUserId());
                borrowInfo.put("borrowresult", true);
                borrowInfo.put("borrowinfo", Constants.BMS_BORROW_SUCCESS);
            } catch (BorrowBookException e) {
                borrowInfo.put("borrowresult", false);
                borrowInfo.put("borrowinfo", e.getMessage());
            }
        } else {
            borrowInfo.put("borrowresult", false);
            borrowInfo.put("borrowinfo", Constants.BMS_BORROW_NOSTUDENTNUMBER);
        }
        return borrowInfo;
    }

    @RequestMapping(value = "/userborrowinfo", method = RequestMethod.POST)
    @ResponseBody
    public BorrowBooksInfoVo userBorrowBooksList(@RequestParam(value = "current",defaultValue = "1")String current,
            @RequestParam(value = "startTime", defaultValue = "") String startTime,
            @RequestParam(value = "endTime", defaultValue = "") String endTime,
            @RequestParam(value = "keyWord", defaultValue = "") String keyWord,
            @RequestParam(value = "category", defaultValue = "") String category){
        BorrowBooksInfoVo borrowBooksInfoVo = new BorrowBooksInfoVo();
        PageSetVo pageSetVo = new PageSetVo();
        pageSetVo.setCurrentpage(Integer.parseInt(current));
        pageSetVo.setPagevalue(6);
        borrowBooksInfoVo.setPageSetVo(pageSetVo);
        borrowBooksInfoVo.setStartTime(DateUtil.getSimpleDate(startTime));
        borrowBooksInfoVo.setEndTime(DateUtil.getSimpleDate(endTime));
        if (!keyWord.equals("")) {
            borrowBooksInfoVo.setKeyWord(keyWord);
        }
        if (!Constants.BMS_CATEGORY_ALL.equals(category)) {
            borrowBooksInfoVo.setCategory(category);
        }
        borrowBooksInfoVo.setUserid(Integer.parseInt(this.getUserId()));
        borrowBooksInfoVo.setIsreturn(false);
        borrowService.getUserBorrowBooksInfo(borrowBooksInfoVo);
        return borrowBooksInfoVo;
    }
}
