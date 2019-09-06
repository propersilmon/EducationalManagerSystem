package com.ems.mapper;

import com.ems.entity.StudentCourse;
import com.ems.vo.StudentChoseCourse;

import java.util.List;

public interface StudentCourseMapper {
    int deleteByPrimaryKey(Integer sCId);

    int insert(StudentCourse record);

    int insertSelective(StudentCourse record);

    StudentCourse selectByPrimaryKey(Integer sCId);

    int updateByPrimaryKeySelective(StudentCourse record);

    int updateByPrimaryKey(StudentCourse record);
    int deletbycId(int cId);

    List<StudentCourse> queryAllStudentCourseByS_id(String sId);

    int delteXK(StudentCourse studentCourse);

    int delteXX(StudentCourse studentCourse);
}