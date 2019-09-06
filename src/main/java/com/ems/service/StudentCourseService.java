package com.ems.service;

import com.ems.entity.StudentCourse;

import java.util.List;

public interface StudentCourseService {
    /*查询t_student_courser表中sid和score信息*/
    List<StudentCourse> selectStudentCourse();

    int updateScore(StudentCourse studentCourse);

    StudentCourse selectStudentById(String s_id, int c_id);

    int insertCourse(int scId, int course);
}
