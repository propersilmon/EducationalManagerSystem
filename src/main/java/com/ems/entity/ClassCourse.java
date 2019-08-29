package com.ems.entity;

public class ClassCourse {
    private Integer cCId;

    private String sClass;

    private Integer cId;

    public ClassCourse(Integer cCId, String sClass, Integer cId) {
        this.cCId = cCId;
        this.sClass = sClass;
        this.cId = cId;
    }

    public ClassCourse() {
        super();
    }

    public Integer getcCId() {
        return cCId;
    }

    public void setcCId(Integer cCId) {
        this.cCId = cCId;
    }

    public String getsClass() {
        return sClass;
    }

    public void setsClass(String sClass) {
        this.sClass = sClass == null ? null : sClass.trim();
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }
}