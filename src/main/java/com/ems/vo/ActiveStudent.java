package com.ems.vo;

public class ActiveStudent {

    //学号
    private String sId;
    //学生姓名
    private String sName;
    //学生性别
    private String sSex;
    //入学时间
    private String sStartYear;
    //毕业时间
    private String sEndYear;
    //班级代号
    private String sClass;
    //是否在校
    private String sState;

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsSex() {
        return sSex;
    }

    public void setsSex(String sSex) {
        this.sSex = sSex;
    }

    public String getsStartYear() {
        return sStartYear;
    }

    public void setsStartYear(String sStartYear) {
        this.sStartYear = sStartYear;
    }

    public String getsEndYear() {
        return sEndYear;
    }

    public void setsEndYear(String sEndYear) {
        this.sEndYear = sEndYear;
    }

    public String getsClass() {
        return sClass;
    }

    public void setsClass(String sClass) {
        this.sClass = sClass;
    }

    public String getsState() {
        return sState;
    }

    public void setsState(String sState) {
        this.sState = sState;
    }
}
