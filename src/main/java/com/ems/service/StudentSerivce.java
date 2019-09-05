package com.ems.service;

import com.ems.entity.Student;
import com.ems.entity.StudentCourse;
import com.ems.vo.StudentChoseCourse;

import java.util.List;

public interface StudentSerivce {


    List<Student> queryStudentByPage(int currentPageIdx);

    int totalStudentCount();

    int addStudent(Student student);

    int updateStudentByStudent(Student student);

    int delteStudentById(String id);

    Student queryStudentById(String id);

    /*查询student表中学生信息*/
    List<Student> selectStudent();
    /*根据id查询学生信息*/
    Student selectStudentById(int s_id);



    List<Student> queryByPage(int currentPage, int recordPerPage);

    /*退课*/
    int dropCourseCourseByS_c_id(int sCId);
    /*查询学生选课表*/
    List<StudentChoseCourse> queryAllStudentCourseByS_id(String sId);
    /*修改教师评分*/
    int updateT_scoreByS_c_id(int tScore,int sCId);


}
