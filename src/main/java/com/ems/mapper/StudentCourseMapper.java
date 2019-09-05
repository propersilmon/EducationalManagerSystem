package com.ems.mapper;

import com.ems.entity.StudentCourse;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.ems.vo.StudentChoseCourse;

public interface StudentCourseMapper {
    int deleteByPrimaryKey(Integer sCId);

    int insert(StudentCourse record);

    int insertSelective(StudentCourse record);

    StudentCourse selectByPrimaryKey(Integer sCId);

    int updateByPrimaryKeySelective(StudentCourse record);

    int updateByPrimaryKey(StudentCourse record);

    List<StudentCourse> selectStudentCourse();

    int updateScore(StudentCourse studentCourse);

    StudentCourse selectStudentById(@Param("sId") String s_id, @Param("cId")int c_id);

    int insertCourse(@Param("sCId")int scId,  @Param("sScore")int course);
    int deletbycId(int cId);

    List<StudentCourse> queryAllStudentCourseByS_id(String sId);

}