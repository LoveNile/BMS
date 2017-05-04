package com.bms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bms.po.BookRenew;
import com.bms.po.BookRenewExample;

public interface BookRenewMapper {
    int countByExample(BookRenewExample example);

    int deleteByExample(BookRenewExample example);

    int deleteByPrimaryKey(Integer bookrenewid);

    int insert(BookRenew record);

    int insertSelective(BookRenew record);

    List<BookRenew> selectByExample(BookRenewExample example);

    BookRenew selectByPrimaryKey(Integer bookrenewid);

    int updateByExampleSelective(@Param("record") BookRenew record, @Param("example") BookRenewExample example);

    int updateByExample(@Param("record") BookRenew record, @Param("example") BookRenewExample example);

    int updateByPrimaryKeySelective(BookRenew record);

    int updateByPrimaryKey(BookRenew record);
}