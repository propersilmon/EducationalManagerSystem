package com.ems.entity;

public class SysPermission {
    private Integer pId;

    private Integer parentId;

    private String type;

    private String pName;

    private String pDesc;

    public SysPermission(Integer pId, Integer parentId, String type, String pName, String pDesc) {
        this.pId = pId;
        this.parentId = parentId;
        this.type = type;
        this.pName = pName;
        this.pDesc = pDesc;
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