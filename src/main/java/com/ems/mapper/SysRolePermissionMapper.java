package com.ems.mapper;

import com.ems.entity.SysRolePermission;

public interface SysRolePermissionMapper {
    int deleteByPrimaryKey(Integer rPId);

    int insert(SysRolePermission record);

    int insertSelective(SysRolePermission record);

    SysRolePermission selectByPrimaryKey(Integer rPId);

    int updateByPrimaryKeySelective(SysRolePermission record);

    int updateByPrimaryKey(SysRolePermission record);
}