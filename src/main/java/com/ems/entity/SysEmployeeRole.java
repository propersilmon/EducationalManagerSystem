package com.ems.entity;

public class SysEmployeeRole {
    private Integer eRId;

    private Integer eId;

    private Integer rId;

    public SysEmployeeRole(Integer eRId, Integer eId, Integer rId) {
        this.eRId = eRId;
        this.eId = eId;
        this.rId = rId;
    }

    public SysEmployeeRole() {
        super();
    }

    public Integer geteRId() {
        return eRId;
    }

    public void seteRId(Integer eRId) {
        this.eRId = eRId;
    }

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }
}