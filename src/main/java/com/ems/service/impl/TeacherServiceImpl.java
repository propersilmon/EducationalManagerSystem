package com.ems.service.impl;

import com.ems.entity.Course;
import com.ems.entity.CourseRoom;
import com.ems.entity.Room;
import com.ems.entity.SysEmployee;
import com.ems.mapper.CourseMapper;
import com.ems.mapper.CourseRoomMapper;
import com.ems.mapper.RoomMapper;
import com.ems.mapper.SysEmployeeMapper;
import com.ems.service.TeacherService;
import com.ems.vo.TeacherCourseAndRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private CourseRoomMapper courseRoomMapper;
    @Autowired
    private RoomMapper roomMapper;
    @Override
    public List<Course> selectCourseById(int employeeId) {
        return courseMapper.selectCourseById(employeeId);
    }

    @Override
    public List<CourseRoom> selectCourseRoomByCourseId(int cId) {
        return courseRoomMapper.selectCourseRoomByCourseId(cId);
    }

    @Override
    public List<Room> selectRoomByRoomId(int rid) {
        return roomMapper.selectRoomByRoomId(rid);
    }
}
