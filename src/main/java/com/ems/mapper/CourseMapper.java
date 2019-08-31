package com.ems.mapper;

import com.ems.entity.Course;

import java.util.List;

public interface CourseMapper {
    int deleteByPrimaryKey(Integer cId);

    int insert(Course record);

    int addCourse(Course record);

    Course selectByPrimaryKey(Integer cId);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
    /*查询courser*/
    List<Course> selectCourseById(int eId);

    List<Course> queryBycName(String s);

    List<Course> queryAllCourse();
}