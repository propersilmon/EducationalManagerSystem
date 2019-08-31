package com.ems.entity;

public class Room {
    //教室号
    private Integer rId;
    //教室位置
    private String position;
    //教室座位最大容量
    private Integer maxCount;

    public Room(Integer rId, String position, Integer maxCount) {
        this.rId = rId;
        this.position = position;
        this.maxCount = maxCount;
    }

    public Room() {
        super();
    }

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public Integer getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(Integer maxCount) {
        this.maxCount = maxCount;
    }

    @Override
    public String toString() {
        return "Room{" +
                "rId=" + rId +
                ", position='" + position + '\'' +
                ", maxCount=" + maxCount +
                '}';
    }
}