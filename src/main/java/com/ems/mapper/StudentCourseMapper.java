package com.ems.mapper;

import com.ems.entity.StudentCourse;

public interface StudentCourseMapper {
    int deleteByPrimaryKey(Integer sCId);

    int insert(StudentCourse record);

    int insertSelective(StudentCourse record);

    StudentCourse selectByPrimaryKey(Integer sCId);

    int updateByPrimaryKeySelective(StudentCourse record);

    int updateByPrimaryKey(StudentCourse record);
}