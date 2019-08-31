package com.ems.service.impl;

import com.ems.entity.Student;
import com.ems.entity.StudentCourse;
import com.ems.mapper.StudentMapper;
import com.ems.service.StudentSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentSerivce {
    @Autowired
    private StudentMapper studentMapper;


    @Override
    public List<Student> queryStudentByPage(int currentPageIdx) {
        //每页查10个
        return studentMapper.queryStudentByPage((currentPageIdx-1),10);
    }

    @Override
    public int totalStudentCount() {
        return studentMapper.totalStudentCount();
    }

    @Override
    public int addStudent(Student student) {
        return studentMapper.insertSelective(student);
    }

    @Override
    public int updateStudentByStudent(Student student) {
        return studentMapper.updateByPrimaryKeySelective(student);
    }

    @Override
    public int delteStudentById(String id) {
        return studentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Student queryStudentById(String id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int dropCourseCourseByS_c_id(int sCId) {
        return studentMapper.dropCourseCourseByS_c_id(sCId);
    }

    @Override
    public List<StudentCourse> queryAllStudentCourseByS_id(int currentPageIdx,String sId) {
        return studentMapper.queryAllStudentCourseByS_id(sId,(currentPageIdx-1),10);
    }

    @Override
    public int updateT_scoreByS_c_id(int sCId,int tScore) {
        return studentMapper.updateT_scoreByS_c_id(sCId,tScore);
    }

    @Override
    public int totalStudentCourseCount() {
        return studentMapper.totalStudentCourseCount();
    }


}
