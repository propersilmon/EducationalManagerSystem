package com.ems.entity;

public class SysRolePermission {
    //权限id
    private Integer rPId;
    //角色id
    private Integer rId;
    //权限id
    private Integer pId;

    public SysRolePermission(Integer rPId, Integer rId, Integer pId) {
        this.rPId = rPId;
        this.rId = rId;
        this.pId = pId;
    }

    @Override
    public String toString() {
        return "SysRolePermission{" +
                "rPId=" + rPId +
                ", rId=" + rId +
                ", pId=" + pId +
                '}';
    }

    public SysRolePermission() {
        super();
    }

    public Integer getrPId() {
        return rPId;
    }

    public void setrPId(Integer rPId) {
        this.rPId = rPId;
    }

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }
}