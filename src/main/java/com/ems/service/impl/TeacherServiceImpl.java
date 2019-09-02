package com.ems.service.impl;

import com.ems.entity.Course;
import com.ems.entity.CourseRoom;
import com.ems.entity.Room;
import com.ems.mapper.CourseMapper;
import com.ems.mapper.CourseRoomMapper;
import com.ems.mapper.RoomMapper;
import com.ems.entity.SysEmployee;
import com.ems.mapper.SysEmployeeMapper;
import com.ems.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    SysEmployeeMapper sysEmployeeMapper;

    @Override
    public SysEmployee queryByUsername(int username) {
        return sysEmployeeMapper.selectByPrimaryKey(username);
    }
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private CourseRoomMapper courseRoomMapper;
    @Autowired
    private RoomMapper roomMapper;
    @Override
    public List<Course> selectCourseById(int eId) {
        return courseMapper.selectCourseById(eId);
    }

    @Override
    public List<CourseRoom> selectCourseRoom() {
        return courseRoomMapper.selectCourseRoom();
    }

    @Override
    public List<Room> selectRoom() {
        return roomMapper.selectRoom();
    }

    @Override
    public Course selectCourseByIdAndCourseName(int eId, String cName) {
        return courseMapper.selectCourseByIdAndCourseName(eId,cName);
    }

}
