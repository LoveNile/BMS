package com.bms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bms.po.Borrow;
import com.bms.po.BorrowExample;

public interface BorrowMapper {
    int countByExample(BorrowExample example);

    int deleteByExample(BorrowExample example);

    int deleteByPrimaryKey(Integer borrowid);

    int insert(Borrow record);

    int insertSelective(Borrow record);

    List<Borrow> selectByExample(BorrowExample example);

    Borrow selectByPrimaryKey(Integer borrowid);

    int updateByExampleSelective(@Param("record") Borrow record, @Param("example") BorrowExample example);

    int updateByExample(@Param("record") Borrow record, @Param("example") BorrowExample example);

    int updateByPrimaryKeySelective(Borrow record);

    int updateByPrimaryKey(Borrow record);
}