package com.ems.mapper;

import com.ems.entity.SysRole;

public interface SysRoleMapper {
    int deleteByPrimaryKey(Integer rId);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Integer rId);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);
}