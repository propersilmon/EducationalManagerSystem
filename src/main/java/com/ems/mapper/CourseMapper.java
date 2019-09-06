package com.ems.mapper;

import com.ems.entity.ClassCourse;
import com.ems.entity.Course;

import java.util.List;

public interface CourseMapper {
    int deleteByPrimaryKey(Course record);

    int insert(Course record);

    int addCourse(Course record);

    Course selectByPrimaryKey(Integer cId);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
    List<Course> queryAllCourse(int page);
    List<Course> queryBycName(String cName,int nPage);
    int queryCourseCount();
    int queryBycNameCount();
    Course queryByKey(int cId);

    List<ClassCourse> queryBXByID(int cId);

    List<Course> queryAllXXCourse();

    List<Course> queryAllCourse1(String sId);

    List<Course> queryAllC();
}