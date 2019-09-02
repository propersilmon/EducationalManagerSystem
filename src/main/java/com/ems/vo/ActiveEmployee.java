package com.ems.vo;

import com.ems.entity.SysPermission;

import java.util.List;

public class ActiveEmployee {

    private int employeeId;
    private String employee_name;
    private String password;
    private String eployee_sex;
    private int e_avg_score;

    private List<SysPermission> menuList;
    private List<SysPermission> permissionList;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEployee_sex() {
        return eployee_sex;
    }

    public void setEployee_sex(String eployee_sex) {
        this.eployee_sex = eployee_sex;
    }

    public int getE_avg_score() {
        return e_avg_score;
    }

    public void setE_avg_score(int e_avg_score) {
        this.e_avg_score = e_avg_score;
    }

    public List<SysPermission> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<SysPermission> menuList) {
        this.menuList = menuList;
    }

    public List<SysPermission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<SysPermission> permissionList) {
        this.permissionList = permissionList;
    }
}
