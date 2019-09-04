package com.ems.service.impl;

import com.ems.entity.CourseRoom;
import com.ems.mapper.CourseRoomMapper;
import com.ems.service.CourseRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: EMS->CourseRoomServicImpl
 * @description:
 * @author: lyl
 * @create: 2019-09-02 10:31
 **/
@Service
public class CourseRoomServiceImpl implements CourseRoomService {
    @Autowired
    CourseRoomMapper courseRoomMapper;
    @Override
    public CourseRoom selectByCId(Integer cId) {
        CourseRoom list= courseRoomMapper.selectByCId(cId);
        return list;
    }

    @Override
    public int insertSelective(CourseRoom record) {
        return courseRoomMapper.insertSelective(record);
    }

    @Override
    public int deleteCourseRoom(CourseRoom courseRoom) {
        return courseRoomMapper.deleteByPrimaryKey(courseRoom.getcRId());
    }

    @Override
    public CourseRoom selectByKey(int crid) {
        return courseRoomMapper.selectByPrimaryKey(crid);
    }

    @Override
    public int updateCourseRoom(CourseRoom courseRoom) {
        return courseRoomMapper.updateByPrimaryKeySelective(courseRoom);
    }
}
