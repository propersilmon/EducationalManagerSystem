package com.ems.service;



import com.ems.entity.SysRole;

import java.util.List;

public interface RoleService {
    List<SysRole> queryAll();

    List<SysRole> queryRoleByEId(int eid);
}
