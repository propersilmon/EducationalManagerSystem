package com.ems.mapper;

import com.ems.entity.Course;

import java.util.List;

public interface CourseMapper {
    int deleteByPrimaryKey(Course record);

    int insert(Course record);

    int addCourse(Course record);

    Course selectByPrimaryKey(Integer cId);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
    List<Course> queryAllCourse();
    List<Course> queryBycName(String cName);

    List<Course> selectCNameByEId(int eId);
    List<Course> queryAllCourse(int page);
    List<Course> queryBycName(String cName,int nPage);
    int queryCourseCount();
    int queryBycNameCount();
}