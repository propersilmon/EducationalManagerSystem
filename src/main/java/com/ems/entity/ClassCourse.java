package com.ems.entity;

public class ClassCourse {
    //班级必修课程id
    private Integer cCId;
    //班级代号
    private String sClass;
    //课程代号
    private Integer cId;

    public ClassCourse(Integer cCId, String sClass, Integer cId) {
        this.cCId = cCId;
        this.sClass = sClass;
        this.cId = cId;
    }

    @Override
    public String toString() {
        return "ClassCourse{" +
                "cCId=" + cCId +
                ", sClass='" + sClass + '\'' +
                ", cId=" + cId +
                '}';
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