package com.ems.service.impl;

import com.ems.entity.CourseRoom;
import com.ems.mapper.CourseRoomMapper;
import com.ems.service.CourseRoomService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @program: EMS->CourseRoomServicImpl
 * @description:
 * @author: lyl
 * @create: 2019-09-02 10:31
 **/
public class CourseRoomServicImpl implements CourseRoomService {
    @Autowired
    CourseRoomMapper courseRoomMapper;
    @Override
    public List<CourseRoom> selectByCId(Integer cId) {
        List<CourseRoom> list= courseRoomMapper.selectByCId(cId);
        return list;
    }
}
