package com.ems.mapper;

import com.ems.entity.SysEmployeeRole;

public interface SysEmployeeRoleMapper {
    int deleteByPrimaryKey(Integer eRId);

    int insert(SysEmployeeRole record);

    int insertSelective(SysEmployeeRole record);

    SysEmployeeRole selectByPrimaryKey(Integer eRId);

    int updateByPrimaryKeySelective(SysEmployeeRole record);

    int updateByPrimaryKey(SysEmployeeRole record);

    void deleteByeId(int eId);

    void addEmployeeRole(int eId, int rId);
}