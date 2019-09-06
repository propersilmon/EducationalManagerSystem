package com.ems.entity;

import java.util.ArrayList;
import java.util.List;

public class SysEmployee {
    //员工id
    private Integer eId;
    //员工姓名
    private String eName;
    //员工密码
    private String ePassword;
    //员工性别
    private String eSex;
    //学生评教平均得分
    private Integer eAvgScore;

    //该员工的角色
    private List<SysRole> roleList;

    public List<SysRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<SysRole> roleList) {
        this.roleList = roleList;
    }

    @Override
    public String toString() {
        return "SysEmployee{" +
                "eId=" + eId +
                ", eName='" + eName + '\'' +
                ", ePassword='" + ePassword + '\'' +
                ", eSex='" + eSex + '\'' +
                ", eAvgScore=" + eAvgScore +
                '}';
    }

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