package com.ems.mapper;

import com.ems.entity.SysPermission;

public interface SysPermissionMapper {
    int deleteByPrimaryKey(Integer pId);

    int insert(SysPermission record);

    int insertSelective(SysPermission record);

    SysPermission selectByPrimaryKey(Integer pId);

    int updateByPrimaryKeySelective(SysPermission record);

    int updateByPrimaryKey(SysPermission record);
}