package com.ems.service.impl;


import com.ems.entity.SysRole;
import com.ems.mapper.SysRoleMapper;
import com.ems.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private SysRoleMapper roleMapper;

    @Override
    public List<SysRole> queryAll() {
        return roleMapper.queryAll();
    }

    @Override
    public List<SysRole> queryRoleByEId(int eid) {
        return roleMapper.queryRoleByEId(eid);
    }
}
