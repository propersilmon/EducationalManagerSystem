package com.ems.entity;

public class StudentCourse {
    //选课表id
    private Integer sCId;
    //学生学号
    private String sId;
    //课程表id
    private Integer cId;
    //课程成绩
    private Integer sScore;
    //评教成绩
    private Integer tScore;

    public StudentCourse(Integer sCId, String sId, Integer cId, Integer sScore, Integer tScore) {
        this.sCId = sCId;
        this.sId = sId;
        this.cId = cId;
        this.sScore = sScore;
        this.tScore = tScore;
    }

    public StudentCourse() {
        super();
    }

    public Integer getsCId() {
        return sCId;
    }

    public void setsCId(Integer sCId) {
        this.sCId = sCId;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId == null ? null : sId.trim();
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public Integer getsScore() {
        return sScore;
    }

    public void setsScore(Integer sScore) {
        this.sScore = sScore;
    }

    public Integer gettScore() {
        return tScore;
    }

    public void settScore(Integer tScore) {
        this.tScore = tScore;
    }

    @Override
    public String toString() {
        return "StudentCourse{" +
                "sCId=" + sCId +
                ", sId='" + sId + '\'' +
                ", cId=" + cId +
                ", sScore=" + sScore +
                ", tScore=" + tScore +
                '}';
    }

}