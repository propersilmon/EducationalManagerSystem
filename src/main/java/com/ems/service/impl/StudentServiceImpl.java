package com.ems.service.impl;

import com.ems.entity.Student;
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
    public List<Student> selectStudent() {
        return studentMapper.selectStudent();
    }

    @Override
    public Student selectStudentById(int s_id) {
        return studentMapper.selectStudentById(s_id);
    }
}
