package com.ems.entity;

public class SysPermission {
    //权限id
    private Integer pId;
    //父id
    private Integer parentId;
    //类型（是权限或者是权限菜单）
    private String type;
    //权限名
    private String pName;
    //权限描述
    private String pDesc;

    public SysPermission(Integer pId, Integer parentId, String type, String pName, String pDesc) {
        this.pId = pId;
        this.parentId = parentId;
        this.type = type;
        this.pName = pName;
        this.pDesc = pDesc;
    }

    @Override
    public String toString() {
        return "SysPermission{" +
                "pId=" + pId +
                ", parentId=" + parentId +
                ", type='" + type + '\'' +
                ", pName='" + pName + '\'' +
                ", pDesc='" + pDesc + '\'' +
                '}';
    }

    public SysPermission() {
        super();
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }

    public String getpDesc() {
        return pDesc;
    }

    public void setpDesc(String pDesc) {
        this.pDesc = pDesc == null ? null : pDesc.trim();
    }
}