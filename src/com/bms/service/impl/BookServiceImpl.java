package com.bms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bms.exception.EditInfoException;
import com.bms.mapper.BookInfoMapper;
import com.bms.mapper.CategoryCustomMapper;
import com.bms.mapper.StudentMapper;
import com.bms.mapper.UserCustomMapper;
import com.bms.mapper.UserMapper;
import com.bms.po.User;
import com.bms.service.BookService;
import com.bms.vo.BookCustom;
import com.bms.vo.BookQueryVo;
import com.bms.vo.CategoryCustom;

public class BookServiceImpl implements BookService {

    @Autowired
    private BookInfoMapper bookInfoMapper;
    @Autowired
    private CategoryCustomMapper categoryCustomMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private UserCustomMapper userCustomMapper;

    @Override
    public void getBookInfoList(BookQueryVo bookQueryVo) {
        int countBook = bookInfoMapper.getCountBook(bookQueryVo);
        bookQueryVo.getPageSetVo().setTotalcount(countBook);
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

    @Override
    public boolean modifyUserInfo(User user) {
        String errMsg = "";
        boolean isEdit = true;
        if (studentMapper.selectByPrimaryKey(user.getStudentnumber()) != null) {
            if (userCustomMapper.verifyUsername(user) > 0) {
                errMsg += "用户名已注册！";
                isEdit = false;
            }
            if (userCustomMapper.verifyUserEmail(user) > 0) {
                errMsg += "邮箱已绑定！";
                isEdit = false;
            }
            if (!studentMapper.selectByPrimaryKey(user.getStudentnumber()).getStudentstatus()) {
                errMsg += "该学生离校！";
                isEdit = false;
            } else {
                if (userCustomMapper.verifyStudent(user) > 0) {
                    errMsg += "学号已绑定";
                    isEdit = false;
                }
            }
        }else {
            errMsg += "不存在此学生！";
            isEdit = false;
        }
        if (isEdit) {
            int countedit = userMapper.updateByPrimaryKeySelective(user);
            if (countedit == 0) {
                throw new EditInfoException("修改失败，请联系管理员！                  ");
            }
        } else {
            throw new EditInfoException(errMsg);
        }
        return true;
    }

    @Override
    public boolean updateUserImg(User user) {
        int count = userMapper.updateByPrimaryKeySelective(user);
        if (count == 0) {
            throw new EditInfoException("编辑图片失败");
        }
        return true;
    }
}
