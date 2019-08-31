package com.ems.vo;

import com.ems.entity.Course;
import com.ems.entity.CourseRoom;
import com.ems.entity.Room;
import java.io.Serializable;
import java.util.List;

public class TeacherCourseAndRoom implements Serializable {
    private  int  eid;
    private  String  ename;
    /** 课程 */
    private List<Course> course;
    /** 课程-教室 */
    private List<CourseRoom> courseRoom;
    /** 教室 */
    private List<Room> room;

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public List<Course> getCourse() {
        return course;
    }

    public void setCourse(List<Course> course) {
        this.course = course;
    }

    public List<CourseRoom> getCourseRoom() {
        return courseRoom;
    }

    public void setCourseRoom(List<CourseRoom> courseRoom) {
        this.courseRoom = courseRoom;
    }

    public List<Room> getRoom() {
        return room;
    }

    public void setRoom(List<Room> room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "TeacherCourseAndRoom{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", course=" + course +
                ", courseRoom=" + courseRoom +
                ", room=" + room +
                '}';
    }

}
