package com.ems.service;

import com.ems.entity.Course;
import com.ems.entity.CourseRoom;
import com.ems.entity.Room;

import java.util.List;

public interface TeacherService {
    List<Course> selectCourseById(int employeeId);

    List<CourseRoom> selectCourseRoom();

    List<Room> selectRoom();
}
