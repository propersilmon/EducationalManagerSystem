package com.ems.vo;

import com.ems.entity.Course;
import com.ems.entity.CourseRoom;
import com.ems.entity.Room;
import com.ems.entity.SysEmployee;

import java.util.List;

/**
 * @program: EMS->Course_Teacher_RoomVoPoJO
 * @description: 保存课程，老师，教室1-1-1关系
 * @author: lyl
 * @create: 2019-09-02 09:35
 **/
public class Course_Teacher_RoomVoPoJO {
    private SysEmployee sysEmployee;
    private Course course;
    private List<Room> room;
    private List<CourseRoom> courseRooms;

    @Override
    public String toString() {
        return "Course_Teacher_RoomVoPoJO{" +
                "sysEmployee=" + sysEmployee +
                ", course=" + course +
                ", room=" + room +
                ", courseRooms=" + courseRooms +
                '}';
    }

    public Course_Teacher_RoomVoPoJO() {
    }

    public Course_Teacher_RoomVoPoJO(SysEmployee sysEmployee, Course course, List<Room> room, List<CourseRoom> courseRooms) {
        this.sysEmployee = sysEmployee;
        this.course = course;
        this.room = room;
        this.courseRooms = courseRooms;
    }

    public SysEmployee getSysEmployee() {
        return sysEmployee;
    }

    public void setSysEmployee(SysEmployee sysEmployee) {
        this.sysEmployee = sysEmployee;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Room> getRoom() {
        return room;
    }

    public void setRoom(List<Room> room) {
        this.room = room;
    }

    public List<CourseRoom> getCourseRooms() {
        return courseRooms;
    }

    public void setCourseRooms(List<CourseRoom> courseRooms) {
        this.courseRooms = courseRooms;
    }
}
