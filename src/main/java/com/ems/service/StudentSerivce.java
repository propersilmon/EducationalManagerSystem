package com.ems.service;

import com.ems.entity.Student;

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


}
