package com.ems.entity;

import java.util.Date;

public class Course {
    //课程号
    private Integer cId;
    //课程名称
    private String cName;
    //学分
    private Integer cCredit;
    //是否为选修
    private Byte elective;
    //创建时间
    private Date createDate;
    //员工号
    private Integer eId;

    public Course(Integer cId, String cName, Integer cCredit, Byte elective, Date createDate, Integer eId) {
        this.cId = cId;
        this.cName = cName;
        this.cCredit = cCredit;
        this.elective = elective;
        this.createDate = createDate;
        this.eId = eId;
    }

    public Course() {
        super();
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public Integer getcCredit() {
        return cCredit;
    }

    public void setcCredit(Integer cCredit) {
        this.cCredit = cCredit;
    }

    public Byte getElective() {
        return elective;
    }

    public void setElective(Byte elective) {
        this.elective = elective;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cId=" + cId +
                ", cName='" + cName + '\'' +
                ", cCredit=" + cCredit +
                ", elective=" + elective +
                ", createDate=" + createDate +
                ", eId=" + eId +
                '}';
    }
}