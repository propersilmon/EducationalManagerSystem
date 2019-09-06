package com.ems.service;

import com.ems.entity.*;
import com.ems.vo.StudentChoseCourse;

import java.util.List;

public interface StudentSerivce {


    List<Student> queryStudentByPage(int currentPageIdx);

    int totalStudentCount();

    int addStudent(Student student);

    int updateStudentByStudent(Student student);

    int delteStudentById(String id);

    Student queryStudentById(String id);

    List<Student> queryByPage(int currentPage, int recordPerPage);

    /*退课*/
    int dropCourseCourseByS_c_id(int sCId);
    /*查询学生选课表*/
    List<StudentChoseCourse> queryAllStudentCourseByS_id(String sId);
    /*修改教师评分*/
    int updateT_scoreByS_c_id(int tScore,int sCId);


    List<ClassCourse> queryAllBXCourse(String sClass);

    List<ClassCourse> queryBXByID(int cId);

    int delteXK(StudentCourse studentCourse);

    int addAllBXCourse(StudentCourse studentCourse);

    List<Course> queryAllXXCourse();

    List<Course> queryAllCourse1(String sId);

    int delteXX(StudentCourse studentCourse);

    int addXXcourse(StudentCourse studentCourse);

    List<Course> queryAllC();

    List<CourseRoom> queryAllCR(String sId);

    List<Room> queryAllRoom1();

}
