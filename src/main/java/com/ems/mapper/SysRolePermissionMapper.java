package com.ems.mapper;

import com.ems.entity.SysPermission;
import com.ems.entity.SysRolePermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRolePermissionMapper {
    int deleteByPrimaryKey(Integer rPId);

    int insert(SysRolePermission record);

    int insertSelective(SysRolePermission record);

    SysRolePermission selectByPrimaryKey(Integer rPId);

    int updateByPrimaryKeySelective(SysRolePermission record);

    int updateByPrimaryKey(SysRolePermission record);

    void deletePermissionByrId(@Param("rId") int rId);

    void addPermission(@Param("rId") int rId, @Param("pId") int pId);
}