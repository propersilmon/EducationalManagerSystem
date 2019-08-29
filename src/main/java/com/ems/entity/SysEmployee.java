package com.ems.entity;

public class SysEmployee {
    private Integer eId;

    private String eName;

    private String ePassword;

    private String eSex;

    private Integer eAvgScore;

    public SysEmployee(Integer eId, String eName, String ePassword, String eSex, Integer eAvgScore) {
        this.eId = eId;
        this.eName = eName;
        this.ePassword = ePassword;
        this.eSex = eSex;
        this.eAvgScore = eAvgScore;
    }

    public SysEmployee() {
        super();
    }

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName == null ? null : eName.trim();
    }

    public String getePassword() {
        return ePassword;
    }

    public void setePassword(String ePassword) {
        this.ePassword = ePassword == null ? null : ePassword.trim();
    }

    public String geteSex() {
        return eSex;
    }

    public void seteSex(String eSex) {
        this.eSex = eSex == null ? null : eSex.trim();
    }

    public Integer geteAvgScore() {
        return eAvgScore;
    }

    public void seteAvgScore(Integer eAvgScore) {
        this.eAvgScore = eAvgScore;
    }
}