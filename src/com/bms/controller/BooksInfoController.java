package com.bms.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bms.Constants;
import com.bms.exception.EditInfoException;
import com.bms.po.User;
import com.bms.service.BookService;
import com.bms.util.DateUtil;
import com.bms.vo.BookCustom;
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
             @RequestParam(value = "endTime", defaultValue = "") String endTime,
             @RequestParam(value = "keyWord", defaultValue = "") String keyWord,
             @RequestParam(value = "category", defaultValue = "") String category) {
        BookQueryVo bookQueryVo = new BookQueryVo();
        PageSetVo pageSetVo = new PageSetVo();
        pageSetVo.setCurrentpage(Integer.parseInt(current));
        pageSetVo.setPagevalue(6);
        bookQueryVo.setPageSetVo(pageSetVo);
        bookQueryVo.setStartTime(DateUtil.getSimpleDate(startTime));
        bookQueryVo.setEndTime(DateUtil.getSimpleDate(endTime));
        if (!keyWord.equals("")) {
            bookQueryVo.setKeyWord(keyWord);
        }
        if (!Constants.BMS_CATEGORY_ALL.equals(category)) {
            bookQueryVo.setCategory(category);
        }
        bookService.getBookInfoList(bookQueryVo);
        return bookQueryVo;
    }

    @RequestMapping(value = "/detail",  method = RequestMethod.POST)
    @ResponseBody
    public BookCustom getDetaiBookInfo(@RequestParam(value = "bookid", defaultValue = "")String bookid){
        return bookService.getBookInfo(bookid);
    }

    @RequestMapping(value = "/usereditinfo", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> editUserInfo(@RequestParam(value = "username", defaultValue = "")String username,
            @RequestParam(value = "studentnumber")String studentnumber,
            @RequestParam(value = "email")String email,
            @RequestParam(value = "phone")String phone,
            @RequestParam(value = "gender")String gender,
            @RequestParam(value = "birthday")String birthday) {
        User user = new User();
        user.setUserid(Integer.parseInt(this.getUserId()));
        user.setUsername(username);
        user.setStudentnumber(Long.parseLong(studentnumber));
        user.setEmail(email);
        user.setPhone(phone);
        user.setBirthday(DateUtil.getSimpleDate(birthday));
        if ("男".equals(gender)) {
            user.setGender(true);
        } else {
            user.setGender(false);
        }
        Map<String, Object> edit = new HashMap<String, Object>();
        try {
            bookService.modifyUserInfo(user);
            edit.put("editresult", true);
            edit.put("editmsg", "修改成功！");
        } catch (EditInfoException e) {
            edit.put("editresult", false);
            edit.put("editmsg", e.getMessage());
        }
        return edit;
    }

    @RequestMapping(value = "/editimg",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> editUserImd(@RequestParam(value = "file")MultipartFile file) {
        Map<String, Object> editImg = new HashMap<String, Object>();
        editImg.put("editresult", false);
        if (file != null) {
            String filePath = "D:\\userpic\\";
            String originalFilename = file.getOriginalFilename();
            String newpicname = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
            File newFile = new File(filePath+newpicname);
            try {
                User user = new User();
                user.setUserid(Integer.parseInt(this.getUserId()));
                user.setPicpath(newpicname);
                bookService.updateUserImg(user);
                file.transferTo(newFile);
                editImg.put("editresult", true);
                editImg.put("editmsg", newpicname);
                return editImg;
            } catch (Exception e) {
                return editImg;
            }
        }
        return editImg;
    }
}
