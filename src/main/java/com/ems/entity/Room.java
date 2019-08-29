package com.ems.entity;

public class Room {
    private Integer rId;

    private String position;

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
}