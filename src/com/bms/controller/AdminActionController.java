package com.bms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bms.Constants;
import com.bms.exception.EditInfoException;
import com.bms.exception.ForgetPasswordException;
import com.bms.po.Admin;
import com.bms.po.Book;
import com.bms.po.Student;
import com.bms.po.User;
import com.bms.service.AdminService;
import com.bms.util.DateUtil;
import com.bms.vo.BookCustom;

@Controller
@RequestMapping(value = "adminaction")
public class AdminActionController extends BaseController {
    @Autowired
    private AdminService adminService;


    @RequestMapping(value = "/management", method = RequestMethod.GET)
    public String adminManagement() {
        return "management";
    }

    @RequestMapping(value = "/alluser")
    public ModelAndView getAllUserInfo() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("alluserinfo");
        modelAndView.addObject("AllUser", adminService.getAllUserInfo());
        return modelAndView;
    }

    @RequestMapping(value = "/allbook")
    @ResponseBody
    public ModelAndView getAllBook() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("allbookinfo");
        modelAndView.addObject("book", adminService.getBookInfo());
        return modelAndView;
    }

    @RequestMapping(value = "/admininfo")
    public ModelAndView getAdminInfo() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpersonal");
        Admin admininfo =  (Admin)this.getSession(Constants.BMS_ADMIN);
        modelAndView.addObject("admininfo", adminService.getAdminInfoByid(admininfo.getAdminid()));
        this.addSession(Constants.BMS_ADMIN, admininfo);
        return modelAndView;
    }

    @RequestMapping(value = "edit")
    public String toEditPage() {
        return "admininfoedit";
    }

    @RequestMapping(value = "/editadmin",method = RequestMethod.POST)
    public ModelAndView editAdminInfo(@RequestParam(value = "adminname")String adminnane,
            @RequestParam(value="adminphone")String phone,
            @RequestParam(value="adminemail")String email,
            @RequestParam(value ="adminaddress")String address,
            @RequestParam(value ="adminremaker")String remaker,
            @RequestParam(value ="admincard")String card) {
        Admin admin = new Admin();
        Admin admininfo =  (Admin)this.getSession(Constants.BMS_ADMIN);
        admin.setAdminid(admininfo.getAdminid());
        admin.setAdminname(adminnane);
        admin.setAdminphone(phone);
        admin.setAdminemail(email);
        admin.setAdminaddress(address);
        admin.setAdminremarks(remaker);
        admin.setAdmincard(card);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admininfoedit");
        try {
            Admin readmin = adminService.updateAdminInfo(admin);
            this.addSession(Constants.BMS_ADMIN, readmin);
            modelAndView.addObject("result", true);
        } catch (EditInfoException e) {
            modelAndView.addObject("result", false);
            modelAndView.addObject("msg", e.getMessage());
        }
        return modelAndView;
    }

    @RequestMapping(value = "/deluser", method = RequestMethod.POST)
    @ResponseBody
    public boolean deleteUser(@RequestParam(value ="userid")String userid) {
        Admin admininfo =  (Admin)this.getSession(Constants.BMS_ADMIN);
        if (adminService.DelateUserById(userid, admininfo.getAdminid())) {
            return true;
        }
        return false;
    }

    @RequestMapping(value = "viewuserinfo")
    @ResponseBody
    public User getUserById(@RequestParam(value="userid")String userid) {
        return adminService.viewUserinfo(userid);
    }

    @RequestMapping(value = "addbook")
    @ResponseBody
    public boolean addbook(@RequestParam(value="")String bookname,
            @RequestParam(value="")String bookauthor,
            @RequestParam(value="")String categoryname,
            @RequestParam(value="")String bookpress,
            @RequestParam(value="")String publishdate,
            @RequestParam(value="")String bookintroduction,
            @RequestParam(value="")String bookaddress,
            @RequestParam(value="")String bookpicpath,
            @RequestParam(value="")String booknumber) {
        Book book = new Book();
        book.setBookname(bookname);
        book.setBookauthor(bookauthor);
        book.setCategoryid(adminService.selectCategotyNameById(categoryname));
        book.setBookaddress(bookaddress);
        book.setPublisheddate(DateUtil.getSimpleDate(publishdate));
        book.setBookintroduction(bookintroduction);
        book.setBookaddress(bookaddress);
        book.setBookpicpath(bookpicpath);
        book.setDelmaker(false);
        book.setBookentertime(DateUtil.getNowDate());
        if (!adminService.toAddBook(book, Integer.parseInt(booknumber))) {
            return false;
        }
        return true;
    }

    @RequestMapping(value = "updateadminpassword")
    public ModelAndView updateAdminPassword(@RequestParam(value = "newpassword")String newpassword,
            @RequestParam(value = "oldpassword")String oldpassword) {
        Admin admininfo =  (Admin)this.getSession(Constants.BMS_ADMIN);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminupdatepassword");
        try {
            adminService.modifyAdminPassword(oldpassword, newpassword, admininfo.getAdminid());
            modelAndView.addObject("result", true);
        } catch (ForgetPasswordException e) {
            modelAndView.addObject("result", false);
            modelAndView.addObject("msg", e.getMessage());
        }
        return modelAndView;
    }

    @RequestMapping(value = "viewstudentinfo",method = RequestMethod.POST )
    @ResponseBody
    public Student adminViewStudentInfo(@RequestParam(value = "studentnumber")String studentnumber) {
        return adminService.getStudentInfo(studentnumber);
    }

    @RequestMapping(value ="/logout", method = RequestMethod.GET)
    public String adminLogout() {
        this.invalidateSession();
        return "admin";
    }
    @RequestMapping(value ="/updatepassword", method = RequestMethod.GET)
    public String toadminpassword() {
        return "adminupdatepassword";
    }

    @RequestMapping(value = "/viewbookdetail")
    @ResponseBody
    public BookCustom getBookInfo(@RequestParam(value="bookid") String bookid) {
        return adminService.getBookCustomById(bookid);
    }

    @RequestMapping(value = "/delbook")
    @ResponseBody
    public boolean adminDeleteBook(@RequestParam(value="bookid") String bookid) {
        Admin admininfo =  (Admin)this.getSession(Constants.BMS_ADMIN);
        try {
            adminService.deleteBookById(bookid, admininfo.getAdminid());
        } catch (Exception e) {
            return false;
        }
        return true;
    };

    @RequestMapping(value = "/viewbookaskborrow")
    public ModelAndView adminViewBookAsk() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("allask");
        modelAndView.addObject("ask", adminService.viewBookAsk());
        return modelAndView;
    }

    @RequestMapping(value = "/viewbookaskback")
    public ModelAndView adminViewBookBack() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("allback");
        modelAndView.addObject("back", adminService.viewBookBack());
        return modelAndView;
    }

    @RequestMapping(value = "/askallow")
    @ResponseBody
    public boolean adminAllowrBorrow() {

        return true;
    }


    @RequestMapping(value = "/viewallborrow")
    public ModelAndView adminViewAllUserBorrow() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("allborrow");
        modelAndView.addObject("back", adminService.viewUserAllBoorrow());
        return modelAndView;
    }
}
