package com.bms.mapper;

import com.bms.po.BookStock;
import com.bms.po.BookStockExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookStockMapper {
    int countByExample(BookStockExample example);

    int deleteByExample(BookStockExample example);

    int deleteByPrimaryKey(Integer bookid);

    int insert(BookStock record);

    int insertSelective(BookStock record);

    List<BookStock> selectByExample(BookStockExample example);

    BookStock selectByPrimaryKey(Integer bookid);

    int updateByExampleSelective(@Param("record") BookStock record, @Param("example") BookStockExample example);

    int updateByExample(@Param("record") BookStock record, @Param("example") BookStockExample example);

    int updateByPrimaryKeySelective(BookStock record);

    int updateByPrimaryKey(BookStock record);
}