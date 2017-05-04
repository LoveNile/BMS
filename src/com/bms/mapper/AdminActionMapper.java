package com.bms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bms.po.AdminAction;
import com.bms.po.AdminActionExample;

public interface AdminActionMapper {
    int countByExample(AdminActionExample example);

    int deleteByExample(AdminActionExample example);

    int deleteByPrimaryKey(Integer adminactionid);

    int insert(AdminAction record);

    int insertSelective(AdminAction record);

    List<AdminAction> selectByExample(AdminActionExample example);

    AdminAction selectByPrimaryKey(Integer adminactionid);

    int updateByExampleSelective(@Param("record") AdminAction record, @Param("example") AdminActionExample example);

    int updateByExample(@Param("record") AdminAction record, @Param("example") AdminActionExample example);

    int updateByPrimaryKeySelective(AdminAction record);

    int updateByPrimaryKey(AdminAction record);
}