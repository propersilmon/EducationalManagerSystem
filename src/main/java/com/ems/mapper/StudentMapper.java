package com.ems.mapper;

import com.ems.entity.Student;

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

        List<Student> selectStudent();

        Student selectStudentById(int s_id);
        }