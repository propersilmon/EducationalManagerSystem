package com.ems.entity;

public class SysRole {
    private Integer rId;

    private String rName;

    private String rDesc;

    public SysRole(Integer rId, String rName, String rDesc) {
        this.rId = rId;
        this.rName = rName;
        this.rDesc = rDesc;
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