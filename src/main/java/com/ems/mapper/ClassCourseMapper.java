package com.ems.mapper;

import com.ems.entity.ClassCourse;

public interface ClassCourseMapper {
    int deleteByPrimaryKey(Integer cCId);

    int insert(ClassCourse record);

    int insertSelective(ClassCourse record);

    ClassCourse selectByPrimaryKey(Integer cCId);

    int updateByPrimaryKeySelective(ClassCourse record);

    int updateByPrimaryKey(ClassCourse record);
    int deletbycId(int cId);
}