package com.ems.service;

import com.ems.entity.*;

import java.util.List;

public interface TeacherService {

    SysEmployee queryByUsername(int username);
    List<Course> selectCourseById(int eId);

    List<CourseRoom> selectCourseRoom();

    List<Room> selectRoom();

    Course selectCourseByIdAndCourseName(int eId, String cName);
    List<Course> selectCNameByEId(int eId);

    List<Student> seleteStudentsByCId(int cId);


    SysEmployee selectEmployeeByENameAndEPassword(String eName,String ePassword);
}
