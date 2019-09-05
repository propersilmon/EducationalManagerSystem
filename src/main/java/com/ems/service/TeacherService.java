package com.ems.service;

import com.ems.entity.Course;
import com.ems.entity.Student;
import com.ems.entity.SysEmployee;
import java.util.List;
import com.ems.entity.CourseRoom;
import com.ems.entity.Room;

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
