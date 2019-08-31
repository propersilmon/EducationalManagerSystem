package com.ems.service;

import com.ems.entity.Course;

import java.util.List;

public interface CourseService {
    Course addCourse(Course course);
    int updateCourse(Course course);
    List<Course> selectAll();
    int deletCourseById(Course course);
    List<Course> selectBycName(String cName);
}
