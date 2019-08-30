package com.ems.enumration;

public enum LoginType {
    STUDENT("Student"),
    SYSEMPLOYEE("SysEmployee");

    private String type;

    private LoginType(String type){
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type.toString();
    }
}
