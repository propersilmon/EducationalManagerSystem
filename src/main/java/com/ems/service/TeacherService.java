package com.ems.service;

import com.ems.entity.Course;
import com.ems.entity.Student;
import com.ems.entity.SysEmployee;

import java.util.List;

public interface TeacherService {
    List<Course> selectCNameByEId(int eId);

    List<Student> seleteStudentsByCId(int cId);

    SysEmployee selectEmployeeByENameAndEPassword(String eName,String ePassword);
}
