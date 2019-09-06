package com.ems.service.impl;


import com.ems.entity.SysEmployee;
import com.ems.entity.SysEmployeeRole;
import com.ems.mapper.SysEmployeeMapper;
import com.ems.mapper.SysEmployeeRoleMapper;
import com.ems.mapper.SysRoleMapper;
import com.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private SysEmployeeMapper sysEmployeeMapper;
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysEmployeeRoleMapper sysEmployeeRoleMapper;

    @Override
    public SysEmployee queryEmployeeById(int employeeId) {
        return sysEmployeeMapper.selectByPrimaryKey(employeeId);
    }

    @Override
    public int updatePasswordByEmployeeId(int employeeId, String newPassword) {
        return sysEmployeeMapper.updatePasswordByEmployeeId(employeeId,newPassword);
    }

    @Override
    public List<SysEmployee> queryEmployeeByPage(int currentPage, int recordPerPage) {
        List<SysEmployee> sysEmployeeList = sysEmployeeMapper.queryEmployeeByPage((currentPage-1)*recordPerPage,recordPerPage);
        for (SysEmployee employee : sysEmployeeList){
            employee.setRoleList(sysRoleMapper.queryRoleByEId(employee.geteId()));
        }
        return sysEmployeeList;
    }

    @Override
    public int getTotalCount() {
        return sysEmployeeMapper.getTotalCount();
    }

    @Override
    public int addEmployeeBackId(SysEmployee employee) {
        return sysEmployeeMapper.addEmployeeBackId(employee);
    }

    @Override
    public List<SysEmployee> queryAll() {
        return sysEmployeeMapper.queryAll();
    }

    @Override
    public void deleteRolesByeId(int eId) {
        sysEmployeeRoleMapper.deleteByeId(eId);
    }

    @Override
    public void addEmployeeRole(int eId, int rId) {
        sysEmployeeRoleMapper.addEmployeeRole(eId, rId);
    }
}
