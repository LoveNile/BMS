package com.bms.test;

import org.junit.Test;

import com.bms.mapper.BookInfoMapper;
import com.bms.mapper.UserMapper;
import com.bms.service.UserService;

public class TestJdbc {

    private UserMapper userMapper;
    private UserService userService;
    private BookInfoMapper bookInfoMapper;

    @org.junit.Before
    public void Test() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        bookInfoMapper = (BookInfoMapper) context.getBean("bookInfoMapper");
//        System.out.println(context);
        int currentPage = Integer.parseInt("-190");
        System.out.println(currentPage);
    }

    @Test
    public void TestMyBatis() {
//        UserExample userExample = new UserExample();
//        UserExample.Criteria userNameCriteria = userExample.createCriteria();
//        UserExample.Criteria userEmailCriteria = userExample.createCriteria();
//        userNameCriteria.andUsernameEqualTo("ni");
//        userEmailCriteria.andEmailEqualTo("1657152515@qq.co");
//        userExample.or(userEmailCriteria);
        try {
//            List<User> userList = userMapper.selectByExample(userExample);
//            List<BookCustom> list = bookInfoMapper.getBookInfo(1);
//            System.out.println(list.size());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void TestLogin() {

    }
}