package com.ems.vo;

import com.ems.entity.Course;
import com.ems.entity.CourseRoom;
import com.ems.entity.Room;
import com.ems.entity.SysEmployee;

/**
 * @program: EMS->Course_Teacher_RoomVoPoJO
 * @description: 保存课程，老师，教室1-1-1关系
 * @author: lyl
 * @create: 2019-09-02 09:35
 **/
public class Course_Teacher_RoomVoPoJO {
    private SysEmployee sysEmployee;
    private Course course;
    private Room room;
    private CourseRoom courseRooms;

    public Course_Teacher_RoomVoPoJO(SysEmployee sysEmployee, Course course, Room room, CourseRoom courseRooms) {
        this.sysEmployee = sysEmployee;
        this.course = course;
        this.room = room;
        this.courseRooms = courseRooms;
    }

    @Override
    public String toString() {
        return "Course_Teacher_RoomVoPoJO{" +
                "sysEmployee=" + sysEmployee +
                ", course=" + course +
                ", room=" + room +
                ", courseRooms=" + courseRooms +
                '}';
    }

    public SysEmployee getSysEmployee() {
        return sysEmployee;
    }

    public Course_Teacher_RoomVoPoJO() {
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

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public CourseRoom getCourseRooms() {
        return courseRooms;
    }

    public void setCourseRooms(CourseRoom courseRooms) {
        this.courseRooms = courseRooms;
    }
}
