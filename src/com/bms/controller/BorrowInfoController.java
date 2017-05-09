package com.bms.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bms.exception.BorrowBookException;
import com.bms.service.BorrowService;

@Controller
@RequestMapping(value = "/borrow")
public class BorrowInfoController extends BaseController {

    @Autowired
    private BorrowService borrowService;

    @RequestMapping(value = "/")
    public void getUserBorrowinfo(){

    }

    @RequestMapping(value = "/userBorrow", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> userBorrowBook(@RequestParam(value = "bookid")String bookid) {
        Map<String, Object> borrowInfo = new HashMap<String, Object>();
        try {
            borrowService.userBorrowBookById(bookid, this.getUserId());
            borrowInfo.put("borrowresult", true);
        } catch (BorrowBookException e) {
            borrowInfo.put("borrowresult", false);
            borrowInfo.put("borrowinfo", e.getMessage());
        }
        return borrowInfo;
    }
}
