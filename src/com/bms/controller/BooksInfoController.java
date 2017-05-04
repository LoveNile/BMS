package com.bms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bms.service.BookService;
import com.bms.util.DateUtil;
import com.bms.vo.BookQueryVo;
import com.bms.vo.PageSetVo;


@Controller
@RequestMapping("/book")
public class BooksInfoController extends BaseController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/bookshow", method = RequestMethod.GET)
    public ModelAndView bookInfoShow() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/book");
        return modelAndView;
    }

    @RequestMapping(value = "/bookinfo", method = RequestMethod.POST)
    @ResponseBody
    public BookQueryVo getBookInfo(@RequestParam(value = "current",defaultValue = "1")String current,
             @RequestParam(value = "startTime", defaultValue = "") String startTime,
             @RequestParam(value = "endTime",  defaultValue = "") String endTime,
             @RequestParam(value = "keyWord", defaultValue = "") String keyWord) {
        BookQueryVo bookQueryVo = new BookQueryVo();
        PageSetVo pageSetVo = new PageSetVo();
        pageSetVo.setCurrentpage(Integer.parseInt(current));
        pageSetVo.setPagevalue(6);
        bookQueryVo.setPageSetVo(pageSetVo);
        bookQueryVo.setStartTime(DateUtil.getSimpleDate(startTime));
        bookQueryVo.setEndTime(DateUtil.getSimpleDate(endTime));
        bookQueryVo.setKeyWord(keyWord);
        bookService.getBookInfoList(bookQueryVo);
        return bookQueryVo;
    }

}
