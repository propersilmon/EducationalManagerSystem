package com.ems.entity;

public class Student {
    private String sId;

    private String sName;

    private String sPassword;

    private String sSex;

    private String sStartYear;

    private String sEndYear;

    private String sClass;

    private String sState;

    public Student(String sId, String sName, String sPassword, String sSex, String sStartYear, String sEndYear, String sClass, String sState) {
        this.sId = sId;
        this.sName = sName;
        this.sPassword = sPassword;
        this.sSex = sSex;
        this.sStartYear = sStartYear;
        this.sEndYear = sEndYear;
        this.sClass = sClass;
        this.sState = sState;
    }

    public Student() {
        super();
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId == null ? null : sId.trim();
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName == null ? null : sName.trim();
    }

    public String getsPassword() {
        return sPassword;
    }

    public void setsPassword(String sPassword) {
        this.sPassword = sPassword == null ? null : sPassword.trim();
    }

    public String getsSex() {
        return sSex;
    }

    public void setsSex(String sSex) {
        this.sSex = sSex == null ? null : sSex.trim();
    }

    public String getsStartYear() {
        return sStartYear;
    }

    public void setsStartYear(String sStartYear) {
        this.sStartYear = sStartYear == null ? null : sStartYear.trim();
    }

    public String getsEndYear() {
        return sEndYear;
    }

    public void setsEndYear(String sEndYear) {
        this.sEndYear = sEndYear == null ? null : sEndYear.trim();
    }

    public String getsClass() {
        return sClass;
    }

    public void setsClass(String sClass) {
        this.sClass = sClass == null ? null : sClass.trim();
    }

    public String getsState() {
        return sState;
    }

    public void setsState(String sState) {
        this.sState = sState == null ? null : sState.trim();
    }
}