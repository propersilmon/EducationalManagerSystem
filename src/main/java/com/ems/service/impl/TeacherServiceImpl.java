package com.ems.service.impl;

import com.ems.entity.SysEmployee;
import com.ems.mapper.SysEmployeeMapper;
import com.ems.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    SysEmployeeMapper sysEmployeeMapper;

    @Override
    public SysEmployee queryByUsername(int username) {
        return sysEmployeeMapper.selectByPrimaryKey(username);
    }
}
