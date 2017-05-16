package com.bms.service;

import java.util.List;

import com.bms.po.Admin;
import com.bms.po.Book;
import com.bms.po.Student;
import com.bms.po.User;
import com.bms.vo.BookCustom;
import com.bms.vo.BorrowCustom;

public interface AdminService {
    Admin adminToLogin(String adminnamne,String adminpassword);
    List<User> getAllUserInfo();
    Admin getAdminInfoByid(int id);
    Admin updateAdminInfo(Admin admin);
    boolean DelateUserById(String userid,int adminid);
    User viewUserinfo(String userid);
    int selectCategotyNameById(String name);
    boolean toAddBook(Book book,int booknumber);
    boolean verifyAdminPassword(int adminid,String password);
    boolean modifyAdminPassword(String oldpassword,String newpassword,int adminid);
    Student getStudentInfo(String studentnumber);
    List<BookCustom> getBookInfo();
    BookCustom getBookCustomById(String bookid);
    boolean deleteBookById(String bookid,int adminid);
    List<BorrowCustom> viewBookAsk();
    List<BorrowCustom> viewBookBack();
    List<BorrowCustom> viewUserAllBoorrow();

}
