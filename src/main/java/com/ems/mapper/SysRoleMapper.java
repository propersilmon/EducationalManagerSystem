package com.ems.mapper;

import com.ems.entity.SysPermission;
import com.ems.entity.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleMapper {
    int deleteByPrimaryKey(Integer rId);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Integer rId);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);
    //追加

    List<SysRole> queryAll();

    List<SysRole> queryRoleByEId(@Param("eId")int eid);

    List<SysRole> queryRolesByPage(int i, int recordPerPage);

    void addRole(String roleName, String desc);
}