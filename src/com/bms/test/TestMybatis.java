package com.bms.test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.bms.mapper.CategoryMapper;
import com.bms.po.Category;

public class TestMybatis {
    private SqlSession sqlSession;
    @Before
    public void loadConfig() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //SqlSessionFactory创建
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
    }

    @Test
    public void TestMybatis() {
        CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);
        Category category = categoryMapper.selectByPrimaryKey(5);
        System.err.println(category.getCategoryname());
    }

}
