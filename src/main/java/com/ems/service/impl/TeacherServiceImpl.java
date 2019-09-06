package com.ems.service.impl;

import com.ems.entity.*;
import com.ems.mapper.*;
import com.ems.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private SysEmployeeMapper sysEmployeeMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private CourseRoomMapper courseRoomMapper;
    @Autowired
    private RoomMapper roomMapper;

    @Override
    public SysEmployee queryByUsername(int username) {
        return sysEmployeeMapper.selectByPrimaryKey(username);
    }

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

    @Override

    public List<Course> selectCNameByEId(int eId) {
        return courseMapper.selectCNameByEId(eId);
    }

    @Override
    public List<Student> seleteStudentsByCId(int cId) {
        Course course = courseMapper.selectByPrimaryKey(cId);
        System.out.println(course);
        List<Student> studentList = studentMapper.selectStudentsByCourse(course);
        return studentList;
    }

    @Override
    public SysEmployee selectEmployeeByENameAndEPassword(String eName, String ePassword) {
        return sysEmployeeMapper.selectEmployeeByENameAndEPassword(eName, ePassword);
    }
}
