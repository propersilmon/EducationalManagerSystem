package com.ems.mapper;

import com.ems.entity.ClassCourse;

import java.util.List;

public interface ClassCourseMapper {
    int deleteByPrimaryKey(Integer cCId);

    int insert(ClassCourse record);

    int insertSelective(ClassCourse record);

    ClassCourse selectByPrimaryKey(Integer cCId);

    int updateByPrimaryKeySelective(ClassCourse record);

    int updateByPrimaryKey(ClassCourse record);
    int deletbycId(int cId);

    List<ClassCourse> queryAllBXCourse(String sClass);
}