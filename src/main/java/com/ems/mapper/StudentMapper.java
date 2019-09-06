package com.ems.mapper;

import com.ems.entity.Course;
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

    List<Student> selectStudentsByCourse(Course course);

    int dropCourseCourseByS_c_id(int s_c_id);

    int updateT_scoreByS_c_id(int tScore,int sCId);

    List<Student> selectStudent();

    Student selectStudentById(int s_id);

}