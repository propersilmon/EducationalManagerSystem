package com.ems.mapper;

import com.ems.entity.SysEmployee;
import org.apache.ibatis.annotations.Param;

public interface SysEmployeeMapper {
    int deleteByPrimaryKey(Integer eId);

    int insert(SysEmployee record);

    int insertSelective(SysEmployee record);

    SysEmployee selectByPrimaryKey(Integer eId);

    int updateByPrimaryKeySelective(SysEmployee record);

    int updateByPrimaryKey(SysEmployee record);

    SysEmployee selectEmployeeByENameAndEPassword(@Param("eName") String eName,@Param("ePassword") String ePassword);
}