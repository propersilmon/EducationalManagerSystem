package com.ems.mapper;

import com.ems.entity.CourseRoom;

import java.util.List;

public interface CourseRoomMapper {
    int deleteByPrimaryKey(Integer cRId);

    int insert(CourseRoom record);

    int insertSelective(CourseRoom record);

    CourseRoom selectByPrimaryKey(Integer cRId);

    int updateByPrimaryKeySelective(CourseRoom record);

    int updateByPrimaryKey(CourseRoom record);

    CourseRoom selectByCId(Integer cId);

    List<CourseRoom> queryAllCR(String sId);
}