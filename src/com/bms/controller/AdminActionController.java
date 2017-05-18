package com.bms.controller;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
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
    public ModelAndView addbook(@RequestParam(value="bookname")String bookname,
            @RequestParam(value="bookauthor")String bookauthor,
            @RequestParam(value="categoryname")String categoryname,
            @RequestParam(value="bookpress")String bookpress,
            @RequestParam(value="bookpublishdate")String publishdate,
            @RequestParam(value="bookintroduction")String bookintroduction,
            @RequestParam(value="bookaddress")String bookaddress,
            @RequestParam(value = "bookimg")MultipartFile multipartFile,
            @RequestParam(value="bookstock")String booknumber) {
        ModelAndView modelAndView = new ModelAndView();
        Admin admininfo =  (Admin)this.getSession(Constants.BMS_ADMIN);
        if (multipartFile != null) {
            String filePath = "D:\\bookpic\\";
            String originalFilename = multipartFile.getOriginalFilename();
            String newpicname = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
            File newFile = new File(filePath+newpicname);
            Book book = new Book();
            book.setBookname(bookname);
            book.setBookauthor(bookauthor);
            book.setCategoryid(adminService.selectCategotyNameId(categoryname));
            book.setBookaddress(bookaddress);
            book.setPublisheddate(DateUtil.getSimpleDate(publishdate));
            book.setBookintroduction(bookintroduction);
            book.setBookaddress(bookaddress);
            book.setDelmaker(false);
            book.setBookentertime(DateUtil.getNowDate());
            book.setBookpicpath(newpicname);
            book.setBookpress(bookpress);
            modelAndView.setViewName("addbook");
            try {
                adminService.toAddBook(book, Integer.parseInt(booknumber),admininfo.getAdminid());
                multipartFile.transferTo(newFile);
                modelAndView.addObject("result", true);
            } catch (Exception e) {
                modelAndView.addObject("result", false);
                modelAndView.addObject("msg", e.getMessage());
            }
            modelAndView.setViewName("addbook");
            modelAndView.addObject("category", adminService.getCategoryname());
        }
        return modelAndView;
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

    @RequestMapping(value = "/askallow", method = RequestMethod.POST)
    @ResponseBody
    public boolean adminAllowrBorrow(@RequestParam(value="borrowid") String borrowid) {
        try {
            Admin admininfo =  (Admin)this.getSession(Constants.BMS_ADMIN);
            adminService.adminAllowAsk(admininfo.getAdminid(), borrowid);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @RequestMapping(value = "/viewallborrow")
    public ModelAndView adminViewAllUserBorrow() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("allborrow");
        modelAndView.addObject("back", adminService.viewUserAllBoorrow());
        return modelAndView;
    }

    @RequestMapping(value = "/askback", method = RequestMethod.POST)
    @ResponseBody
    public boolean adminAllowrBack(@RequestParam(value="borrowid") String borrowid) {
        try {
            Admin admininfo =  (Admin)this.getSession(Constants.BMS_ADMIN);
            adminService.adminAllowBack(admininfo.getAdminid(), borrowid);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @RequestMapping(value = "/quickback", method = RequestMethod.POST)
    @ResponseBody
    public boolean adminToUserQuickBack(@RequestParam(value="userid") String userid) {
        try {
            adminService.quickBack(userid);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @RequestMapping(value = "/categoryview")
    public String adminviewCategory() {
        return "addcategory";
    }

    @RequestMapping(value = "/addcategory", method = RequestMethod.POST)
    public ModelAndView adminaddCategory(@RequestParam(value="categoryname") String categoryname) {
        Admin admininfo =  (Admin)this.getSession(Constants.BMS_ADMIN);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addcategory");
        try {
            adminService.addCategory(categoryname, admininfo.getAdminid());
            modelAndView.addObject("result", true);
        } catch (EditInfoException e) {
            modelAndView.addObject("result", false);
            modelAndView.addObject("msg", e.getMessage());
        }
        return modelAndView;
    }
    @RequestMapping(value = "/toaddbook")
    public ModelAndView toAddBookPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addbook");
        modelAndView.addObject("category", adminService.getCategoryname());
        return modelAndView;
    }

    @RequestMapping(value = "/{bookid}", method = RequestMethod.GET)
    public ModelAndView toEditPage(@PathVariable String bookid) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editbook");
        modelAndView.addObject("book", adminService.getBookCustomById(bookid));
        modelAndView.addObject("category", adminService.getCategoryname());
        return modelAndView;
    }

    @RequestMapping(value="/editbook", method = RequestMethod.POST)
    public ModelAndView editBook(@RequestParam(value="bookid")String bookid,
            @RequestParam(value="bookname")String bookname,
            @RequestParam(value="bookauthor")String bookauthor,
            @RequestParam(value="categoryname")String categoryname,
            @RequestParam(value="bookpress")String bookpress,
            @RequestParam(value="bookpublishdate")String publishdate,
            @RequestParam(value="bookintroduction")String bookintroduction,
            @RequestParam(value="bookaddress")String bookaddress,
            @RequestParam(value = "bookimg")MultipartFile multipartFile) throws Exception {
        Book book = new Book();
        Admin admininfo =  (Admin)this.getSession(Constants.BMS_ADMIN);
        ModelAndView modelAndView = new ModelAndView();
        String filename = multipartFile.getOriginalFilename();
        if (filename != null && !filename.equals("") ) {
            String filePath = "D:\\bookpic\\";
            String originalFilename = multipartFile.getOriginalFilename();
            String newpicname = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
            File newFile = new File(filePath+newpicname);
            multipartFile.transferTo(newFile);
            book.setBookpicpath(newpicname);
        }
        book.setBookid(Long.parseLong(bookid));
        book.setBookname(bookname);
        book.setBookauthor(bookauthor);
        book.setCategoryid(adminService.selectCategotyNameId(categoryname));
        book.setBookaddress(bookaddress);
        book.setPublisheddate(DateUtil.getSimpleDate(publishdate));
        book.setBookintroduction(bookintroduction);
        book.setBookaddress(bookaddress);
        book.setDelmaker(false);
        book.setBookentertime(DateUtil.getNowDate());
        book.setBookpress(bookpress);
        try {
            adminService.updateBookInfo(book, admininfo.getAdminid());
            modelAndView.setViewName("editbook");
            modelAndView.addObject("result", true);
        } catch (EditInfoException e) {
            modelAndView.addObject("result", false);
            modelAndView.addObject("msg", e.getMessage());
        }
        modelAndView.addObject("book", adminService.getBookCustomById(bookid));
        modelAndView.addObject("category", adminService.getCategoryname());
        return modelAndView;
    }
}
