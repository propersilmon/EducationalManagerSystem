package com.ems.service.impl;


import com.ems.entity.SysPermission;
import com.ems.mapper.SysPermissionMapper;
import com.ems.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private SysPermissionMapper sysPermissionMapper;


    @Override
    public List<SysPermission> queryMenuByUserId(Integer geteId) {
        return sysPermissionMapper.queryMenuByUserId(geteId);
    }

    @Override
    public List<SysPermission> queryPermissionByUserId(Integer geteId) {
        return sysPermissionMapper.queryPermissionByUserId(geteId);
    }

    @Override
    public List<SysPermission> queryAll() {
        return sysPermissionMapper.queryAll();
    }
}
