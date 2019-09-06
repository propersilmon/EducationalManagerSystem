package com.ems.service.impl;

import com.ems.entity.SysRole;
import com.ems.mapper.SysPermissionMapper;
import com.ems.mapper.SysRoleMapper;
import com.ems.mapper.SysRolePermissionMapper;
import com.ems.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private SysRoleMapper roleMapper;
    @Autowired
    private SysPermissionMapper sysPermissionMapper;
    @Autowired
    private SysRolePermissionMapper sysRolePermissionMapper;

    @Override
    public List<SysRole> queryAll() {
        return roleMapper.queryAll();
    }

    @Override
    public List<SysRole> queryRoleByEId(int eid) {
        return roleMapper.queryRoleByEId(eid);
    }

    @Override
    public List<SysRole> queryRolesByPage(int currentPage, int recordPerPage) {
        List<SysRole> sysRoleList = roleMapper.queryRolesByPage((currentPage-1)*recordPerPage,recordPerPage);
        for (SysRole sysRole : sysRoleList){
            sysRole.setPermissionList(sysPermissionMapper.queryPermissionByrId(sysRole.getrId()));
        }
        return sysRoleList;

    }

    @Override
    public int getTotalCount() {
        return 0;
    }

    @Override
    public void addRole(String roleName, String desc) {
        roleMapper.addRole(roleName, desc);
    }

    @Override
    public void alterRole(SysRole sysRole) {
        roleMapper.updateByPrimaryKey(sysRole);
    }

    @Override
    public void deleteRoleByrId(int rId) {
        roleMapper.deleteByPrimaryKey(rId);
    }

    @Override
    public void deletePermissionByrId(int rId) {
        sysRolePermissionMapper.deletePermissionByrId(rId);
    }

    @Override
    public void addPermission(int rId, int pId) {
        sysRolePermissionMapper.addPermission(rId, pId);
    }
}
