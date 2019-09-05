package com.ems.mapper;

import com.ems.entity.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper {
    int deleteByPrimaryKey(Course record);

    int insert(Course record);

    int addCourse(Course record);

    Course selectByPrimaryKey(Integer cId);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
/*
    List<Course> queryAllCourse();
*/
/*
    List<Course> queryBycName(String cName);
*/

    List<Course> selectCNameByEId(int eId);
    /*查询courser*/
    List<Course> selectCourseById(int eId);

    Course selectCourseByIdAndCourseName(@Param("eId")int eId, @Param("cName")String cName);
    List<Course> queryAllCourse(int page);
    List<Course> queryBycName(String cName,int nPage);
    int queryCourseCount();
    int queryBycNameCount();

    Course queryByKey(int cId);
}