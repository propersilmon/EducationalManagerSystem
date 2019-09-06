package com.ems.service;


import com.ems.entity.SysPermission;

import java.util.List;

public interface PermissionService {
    List<SysPermission> queryMenuByUserId(Integer geteId);

    List<SysPermission> queryPermissionByUserId(Integer geteId);

    List<SysPermission> queryAll();
}
