package com.ems.mapper;

import com.ems.entity.Student;
import com.ems.entity.StudentCourse;

import java.util.List;

public interface StudentMapper {
    int deleteByPrimaryKey(String sId);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(String sId);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    List<Student> queryStudentByPage(int agr1, int agr2);

    int totalStudentCount();


    int dropCourseCourseByS_c_id(int s_c_id);

    List<StudentCourse> queryAllStudentCourseByS_id(String agr1,int agr2,int agr3);

    int updateT_scoreByS_c_id(int sCId,int tScore);

    int totalStudentCourseCount();
}