package com.ems.mapper;

import com.ems.entity.SysEmployee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysEmployeeMapper {
    int deleteByPrimaryKey(Integer eId);

    int insert(SysEmployee record);

    int insertSelective(SysEmployee record);

    SysEmployee selectByPrimaryKey(Integer eId);

    int updateByPrimaryKeySelective(SysEmployee record);

    int updateByPrimaryKey(SysEmployee record);

    SysEmployee selectEmployeeByENameAndEPassword(@Param("eName") String eName,@Param("ePassword") String ePassword);
    int updatePasswordByEmployeeId(@Param("employeeId") int employeeId, @Param("newPassword") String newPassword);

    List<SysEmployee> queryEmployeeByPage(int i, int recordPerPage);

    int getTotalCount();

    int addEmployeeBackId(SysEmployee employee);
    List<SysEmployee> queryAll();
}