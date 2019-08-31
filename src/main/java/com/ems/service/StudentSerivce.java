package com.ems.service;

import com.ems.entity.Student;
import com.ems.entity.StudentCourse;

import java.util.List;

public interface StudentSerivce {


    List<Student> queryStudentByPage(int currentPageIdx);

    int totalStudentCount();

    int addStudent(Student student);

    int updateStudentByStudent(Student student);

    int delteStudentById(String id);

    Student queryStudentById(String id);

    int dropCourseCourseByS_c_id(int sCId);


    List<StudentCourse> queryAllStudentCourseByS_id(int currentPageIdx,String sId);

    int updateT_scoreByS_c_id(int sCId,int tScore);

    int totalStudentCourseCount();
}
