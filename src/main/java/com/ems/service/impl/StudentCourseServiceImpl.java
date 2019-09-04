package com.ems.service.impl;


import com.ems.entity.StudentCourse;
import com.ems.mapper.StudentCourseMapper;
import com.ems.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentCourseServiceImpl implements StudentCourseService {
    @Autowired
    private StudentCourseMapper studentCourseMapper;
    @Override
    public List<StudentCourse> selectStudentCourse() {
        return studentCourseMapper.selectStudentCourse();
    }

    @Override
    public int updateScore(StudentCourse studentCourse) {
        return studentCourseMapper.updateScore(studentCourse);
    }

    @Override
    public StudentCourse selectStudentById(String s_id, int c_id) {
        return studentCourseMapper.selectStudentById(s_id,c_id);
    }

    @Override
    public int insertCourse(int scId, int course) {
        return studentCourseMapper.insertCourse(scId,course);
    }


}
