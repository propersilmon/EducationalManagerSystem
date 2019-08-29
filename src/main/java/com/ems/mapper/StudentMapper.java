package com.ems.mapper;

import com.ems.entity.Student;

public interface StudentMapper {
    int deleteByPrimaryKey(String sId);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(String sId);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}