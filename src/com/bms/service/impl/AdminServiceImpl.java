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
import com.bms.mapper.BookMapper;
import com.bms.mapper.BookStockCustomMapper;
import com.bms.mapper.BookStockMapper;
import com.bms.mapper.BorrowCustomMapper;
import com.bms.mapper.BorrowMapper;
import com.bms.mapper.CategoryCustomMapper;
import com.bms.mapper.CategoryMapper;
import com.bms.mapper.StudentMapper;
import com.bms.mapper.UserCustomMapper;
import com.bms.mapper.UserMapper;
import com.bms.po.Admin;
import com.bms.po.AdminAction;
import com.bms.po.AdminExample;
import com.bms.po.Book;
import com.bms.po.BookStock;
import com.bms.po.Borrow;
import com.bms.po.Category;
import com.bms.po.CategoryExample;
import com.bms.po.Student;
import com.bms.po.User;
import com.bms.service.AdminService;
import com.bms.util.DateUtil;
import com.bms.util.JMailUtil;
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
    private CategoryCustomMapper categoryCustomMapper;
    @Autowired
    private BookInfoMapper bookInfoMapper;
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private BookStockMapper bookStockMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private BorrowCustomMapper borrowCustomMapper;
    @Autowired
    private BorrowMapper borrowMapper;
    @Autowired
    private BookStockCustomMapper bookStockCustomMapper;


    @Override
    public Admin adminToLogin(String adminnamne, String adminpassword) {
        AdminExample adminExample = new AdminExample();
        adminExample.or().andAdminnameEqualTo(adminnamne);
        List<Admin> list = adminMapper.selectByExample(adminExample);
        if (list.isEmpty()) {
            throw new LoginErrorException("账号不存在！");
        }
        if (!list.get(0).getAdminpassword().equals(adminpassword)) {
            throw new LoginErrorException("密码错误！");
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
    public int selectCategotyNameId(String name) {
        CategoryExample categoryExample = new CategoryExample();
        categoryExample.or().andCategorynameEqualTo(name);
        List<Category> categories = categoryMapper.selectByExample(categoryExample) ;
        return categories.get(0).getCategoryid();
    }

    @Override
    public boolean toAddBook(Book book, int booknumber,int adminid) {
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
            } else {
                AdminAction adminAction = new AdminAction();
                adminAction.setAdminid(adminid);
                adminAction.setAdminactiontime(DateUtil.getNowDate());
                adminAction.setAdminactiontype("添加书籍");
                adminAction.setAdminactionto(book.getBookid().toString());
                int insert = adminActionMapper.insert(adminAction);
                if (insert == 0) {
                    throw new RuntimeException();
                }
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

    @Override
    public void adminAllowAsk(int adminid, String borrowid) {
        Borrow borrow = new Borrow();
        borrow.setBorrowid(Integer.parseInt(borrowid));
        borrow.setBorrowdate(DateUtil.getNowDate());
        borrow.setIsreturn(3);
        borrow.setAllowborrow(adminid);
        int count = borrowMapper.updateByPrimaryKeySelective(borrow);
        if (count == 0) {
            throw new RuntimeException();
        } else {
            AdminAction adminAction = new AdminAction();
            adminAction.setAdminid(adminid);
            adminAction.setAdminactiontime(DateUtil.getNowDate());
            adminAction.setAdminactiontype("允许借阅书籍");
            adminAction.setAdminactionto(borrowid);
            int insert = adminActionMapper.insert(adminAction);
            if (insert == 0) {
                throw new RuntimeException();
            }
        }
    }
    @Override
    public void adminAllowBack(int adminid, String borrowid) {
        Borrow borrow = new Borrow();
        borrow.setBorrowid(Integer.parseInt(borrowid));
        borrow.setBorrowdate(DateUtil.getNowDate());
        borrow.setIsreturn(1);
        borrow.setAllowback(adminid);
        int count = borrowMapper.updateByPrimaryKeySelective(borrow);
        if (count == 0) {
            throw new RuntimeException();
        } else {
            AdminAction adminAction = new AdminAction();
            adminAction.setAdminid(adminid);
            adminAction.setAdminactiontime(DateUtil.getNowDate());
            adminAction.setAdminactiontype("允许还书");
            adminAction.setAdminactionto(borrowid);
            int insert = adminActionMapper.insert(adminAction);
            if (insert == 0) {
                throw new RuntimeException();
            } else {
                int updateStock = bookStockCustomMapper.ChangebookStockById(Integer.parseInt(borrowid));
                if (updateStock == 0) {
                    throw new RuntimeException();
                }
            }
        }
    }
    @Override
    public void quickBack(String userid) throws Exception {
        User user = userMapper.selectByPrimaryKey(Integer.parseInt(userid));
        JMailUtil.BMSSendEmail(user.getEmail(),"快速还书", "请将借阅书籍快速归还！");
    }

    @Override
    public void addCategory(String categoryname, int adminid) {
        int count = categoryCustomMapper.countCategoryname(categoryname);
        if (count > 0) {
            throw new EditInfoException("已经有此分类！");
        }
        Category category = new Category();
        category.setCategoryname(categoryname);
        category.setCategorycreatetime(DateUtil.getNowDate());
        int insertcount = categoryMapper.insert(category);
        if (insertcount == 0) {
            throw new EditInfoException("添加分类错误！");
        }
        AdminAction adminAction = new AdminAction();
        adminAction.setAdminid(adminid);
        adminAction.setAdminactiontime(DateUtil.getNowDate());
        adminAction.setAdminactiontype("添加分类");
        adminAction.setAdminactionto(categoryname);
        int insert = adminActionMapper.insert(adminAction);
        if (insert == 0) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<Category> getCategoryname() {
        return categoryMapper.selectByExample(null);
    }

    @Override
    public void updateBookInfo(Book book, int adminid) {
        int count = bookMapper.updateByPrimaryKeySelective(book);
        if (count == 0) {
            throw new EditInfoException("修改错误错误！");
        } else {
            AdminAction adminAction = new AdminAction();
            adminAction.setAdminid(adminid);
            adminAction.setAdminactiontime(DateUtil.getNowDate());
            adminAction.setAdminactiontype("修改还书");
            adminAction.setAdminactionto(book.getBookid().toString());
            int insert = adminActionMapper.insert(adminAction);
            if (insert == 0) {
                throw new EditInfoException("修改错误错误！");
            }
        }

    }
}
