package com.ems.service.impl;


import com.ems.entity.SysEmployee;
import com.ems.mapper.SysEmployeeMapper;
import com.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private SysEmployeeMapper sysEmployeeMapper;

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
        return sysEmployeeMapper.queryEmployeeByPage((currentPage-1)*recordPerPage,recordPerPage);
    }

    @Override
    public int getTotalCount() {
        return sysEmployeeMapper.getTotalCount();
    }

    @Override
    public int addEmployeeBackId(SysEmployee employee) {
        return sysEmployeeMapper.addEmployeeBackId(employee);
    }
}
