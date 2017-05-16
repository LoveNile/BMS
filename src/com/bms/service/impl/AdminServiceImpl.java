package com.bms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bms.exception.EditInfoException;
import com.bms.exception.ForgetPasswordException;
import com.bms.exception.LoginErrorException;
import com.bms.mapper.AdminActionMapper;
import com.bms.mapper.AdminMapper;
import com.bms.mapper.BookInfoMapper;
import com.bms.mapper.BookStockMapper;
import com.bms.mapper.BorrowCustomMapper;
import com.bms.mapper.CategoryMapper;
import com.bms.mapper.StudentMapper;
import com.bms.mapper.UserCustomMapper;
import com.bms.mapper.UserMapper;
import com.bms.po.Admin;
import com.bms.po.AdminAction;
import com.bms.po.AdminExample;
import com.bms.po.Book;
import com.bms.po.BookStock;
import com.bms.po.Category;
import com.bms.po.CategoryExample;
import com.bms.po.Student;
import com.bms.po.User;
import com.bms.service.AdminService;
import com.bms.util.DateUtil;
import com.bms.vo.BookCustom;
import com.bms.vo.BorrowCustom;

@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private UserCustomMapper userCustomMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AdminActionMapper adminActionMapper;
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private BookInfoMapper bookInfoMapper;
    @Autowired
    private BookStockMapper bookStockMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private BorrowCustomMapper borrowCustomMapper;


    @Override
    public Admin adminToLogin(String adminnamne, String adminpassword) {
        AdminExample adminExample = new AdminExample();
        adminExample.or().andAdminnameEqualTo(adminnamne);
        List<Admin> list = adminMapper.selectByExample(adminExample);
        if (list.isEmpty()) {
            throw new LoginErrorException("");
        }
        if (!list.get(0).getAdminpassword().equals(adminpassword)) {
            throw new LoginErrorException("");
        }
        return list.get(0);
    }

    @Override
    public List<User> getAllUserInfo() {
        List<User> users = userCustomMapper.getAllUser();
        return users;
    }

    @Override
    public Admin getAdminInfoByid(int id) {
       Admin admin = adminMapper.selectByPrimaryKey(id);
        return admin;
    }

    @Override
    public Admin updateAdminInfo(Admin admin) {
        int update = adminMapper.updateByPrimaryKeySelective(admin);
        if (update == 0) {
            throw new EditInfoException("修改错误");
        }
        Admin admininfo = adminMapper.selectByPrimaryKey(admin.getAdminid());
        return admininfo;
    }

    @Override
    public boolean DelateUserById(String userid,int adminid) {
        User user = new User();
        user.setUserid(Integer.parseInt(userid));
        user.setDelmaker(true);
        int delcount = userMapper.updateByPrimaryKeySelective(user);
        if (delcount == 0) {
            throw new RuntimeException();
        } else {
            AdminAction adminAction = new AdminAction();
            adminAction.setAdminid(adminid);
            adminAction.setAdminactiontime(DateUtil.getNowDate());
            adminAction.setAdminactiontype("删除用户");
            adminAction.setAdminactionto(userid);
            int insert = adminActionMapper.insert(adminAction);
            if (insert == 0) {
                throw new RuntimeException();
            }
        }
        return true;
    }

    @Override
    public User viewUserinfo(String userid) {
        return userMapper.selectByPrimaryKey(Integer.parseInt(userid));
    }

    @Override
    public int selectCategotyNameById(String name) {
        CategoryExample categoryExample = new CategoryExample();
        categoryExample.or().andCategorynameEqualTo(name);
        List<Category> categories = categoryMapper.selectByExample(categoryExample) ;
        return categories.get(0).getCategoryid();
    }

    @Override
    public boolean toAddBook(Book book, int booknumber) {
        int count = bookInfoMapper.insertBook(book);
        if (count == 0) {
            return false;
        } else {
            BookStock bookStock = new BookStock();
            bookStock.setBookid(book.getBookid().intValue());
            bookStock.setBooknumber(booknumber);
            bookStock.setUpdatetime(DateUtil.getNowDate());
            int insertcount =  bookStockMapper.insert(bookStock);
            if (insertcount == 0) {
                throw new RuntimeException();
            }
        }
        return true;
    }

    @Override
    public boolean verifyAdminPassword(int adminid,String password) {
        Admin admin = adminMapper.selectByPrimaryKey(adminid);
        if (!admin.getAdminpassword().equals(password)) {
            return false;
        }
        return true;
    }

    @Override
    public boolean modifyAdminPassword(String oldpassword, String newpassword, int adminid) {
        Admin admin = adminMapper.selectByPrimaryKey(adminid);
        if (!admin.getAdminpassword().equals(oldpassword)) {
            throw new ForgetPasswordException("密码错误");
        }
        admin.setAdminpassword(newpassword);
        int updatecount = adminMapper.updateByPrimaryKeySelective(admin);
        if (updatecount == 0) {
            throw new ForgetPasswordException("修改失败");
        }
        return true;
    }

    @Override
    public Student getStudentInfo(String studentnumber) {
        return studentMapper.selectByPrimaryKey(Long.parseLong(studentnumber));
    }

    @Override
    public List<BookCustom> getBookInfo() {
        return bookInfoMapper.adminBookInfo();
    }

    @Override
    public BookCustom getBookCustomById(String bookid) {
        return bookInfoMapper.getDetailBookInfo(Integer.parseInt(bookid));
    }

    @Override
    public boolean deleteBookById(String bookid, int adminid) {
        int delcount = bookInfoMapper.deleteOneBook(Integer.parseInt(bookid));
        if (delcount == 0) {
            throw new RuntimeException();
        } else {
            AdminAction adminAction = new AdminAction();
            adminAction.setAdminid(adminid);
            adminAction.setAdminactiontime(DateUtil.getNowDate());
            adminAction.setAdminactiontype("删除书籍");
            adminAction.setAdminactionto(bookid);
            int insert = adminActionMapper.insert(adminAction);
            if (insert == 0) {
                throw new RuntimeException();
            }
        }
        return true;
    }

    @Override
    public List<BorrowCustom> viewBookAsk() {
        return borrowCustomMapper.selectBorrowStatus(2);
    }

    @Override
    public List<BorrowCustom> viewBookBack() {
        return borrowCustomMapper.selectUserBackBookAsk(0);
    }

    @Override
    public List<BorrowCustom> viewUserAllBoorrow() {
        return borrowCustomMapper.selectUserBackBookAsk(3);
    }


}
