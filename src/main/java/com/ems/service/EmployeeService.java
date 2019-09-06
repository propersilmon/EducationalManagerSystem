package com.ems.service;


import com.ems.entity.SysEmployee;

import java.util.List;

public interface EmployeeService {
    SysEmployee queryEmployeeById(int employeeId);

    int updatePasswordByEmployeeId(int parseInt, String newPassword);

    List<SysEmployee> queryEmployeeByPage(int currentPage, int recordPerPage);

    int getTotalCount();

    int addEmployeeBackId(SysEmployee employee);

    List<SysEmployee> queryAll();

    void deleteRolesByeId(int eId);

    void addEmployeeRole(int eId, int rId);
}
