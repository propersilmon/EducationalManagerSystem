package com.ems.entity;

import java.util.List;

public class SysRole {
    //角色id
    private Integer rId;
    //角色名
    private String rName;
    //角色描述
    private String rDesc;
    //角色对应的权限
    private List<SysPermission> permissionList;

    public SysRole(Integer rId, String rName, String rDesc) {
        this.rId = rId;
        this.rName = rName;
        this.rDesc = rDesc;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "rId=" + rId +
                ", rName='" + rName + '\'' +
                ", rDesc='" + rDesc + '\'' +
                '}';
    }

    public List<SysPermission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<SysPermission> permissionList) {
        this.permissionList = permissionList;
    }

    public SysRole() {
        super();
    }

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName == null ? null : rName.trim();
    }

    public String getrDesc() {
        return rDesc;
    }

    public void setrDesc(String rDesc) {
        this.rDesc = rDesc == null ? null : rDesc.trim();
    }
}