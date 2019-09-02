package com.ems.service;

import com.ems.entity.Course;
import com.ems.entity.CourseRoom;
import com.ems.entity.Room;

import java.util.List;

import com.ems.entity.SysEmployee;

public interface TeacherService {

    SysEmployee queryByUsername(int username);
    List<Course> selectCourseById(int eId);

    List<CourseRoom> selectCourseRoom();

    List<Room> selectRoom();

    Course selectCourseByIdAndCourseName(int eId, String cName);
}
