package com.ems.service;

import com.ems.entity.CourseRoom;

import java.util.List;

public interface CourseRoomService {
    List<CourseRoom> selectByCId(Integer cId);
}
