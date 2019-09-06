package com.ems.mapper;

import com.ems.entity.SysPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysPermissionMapper {
    int deleteByPrimaryKey(Integer pId);

    int insert(SysPermission record);

    int insertSelective(SysPermission record);

    SysPermission selectByPrimaryKey(Integer pId);

    int updateByPrimaryKeySelective(SysPermission record);

    int updateByPrimaryKey(SysPermission record);

    List<SysPermission> queryMenuByUserId(@Param("employeeId") Integer geteId);

    List<SysPermission> queryPermissionByUserId(@Param("employeeId") Integer geteId);

    List<SysPermission> queryPermissionByrId(@Param("rId")int rId);

    List<SysPermission> queryAll();
}