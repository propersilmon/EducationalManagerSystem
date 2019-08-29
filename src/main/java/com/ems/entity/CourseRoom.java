package com.ems.entity;

public class CourseRoom {
    private Integer cRId;

    private String interval;

    private Integer cId;

    private Integer rId;

    private String week;

    private String desc;

    private String startWeek;

    private String endWeek;

    public CourseRoom(Integer cRId, String interval, Integer cId, Integer rId, String week, String desc, String startWeek, String endWeek) {
        this.cRId = cRId;
        this.interval = interval;
        this.cId = cId;
        this.rId = rId;
        this.week = week;
        this.desc = desc;
        this.startWeek = startWeek;
        this.endWeek = endWeek;
    }

    public CourseRoom() {
        super();
    }

    public Integer getcRId() {
        return cRId;
    }

    public void setcRId(Integer cRId) {
        this.cRId = cRId;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval == null ? null : interval.trim();
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week == null ? null : week.trim();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    public String getStartWeek() {
        return startWeek;
    }

    public void setStartWeek(String startWeek) {
        this.startWeek = startWeek == null ? null : startWeek.trim();
    }

    public String getEndWeek() {
        return endWeek;
    }

    public void setEndWeek(String endWeek) {
        this.endWeek = endWeek == null ? null : endWeek.trim();
    }
}