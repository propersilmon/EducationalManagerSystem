package com.ems.service.impl;

import com.ems.entity.Course;
import com.ems.mapper.CourseMapper;
import com.ems.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: EMS->CourseServiceImpl
 * @description:
 * @author: lyl
 * @create: 2019-08-30 15:26
 **/
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseMapper courseMapper;
    @Override
    public int addCourse(Course course) {
        return 0;
    }

    @Override
    public int updateCourse(Course course) {
        return 0;
    }

    @Override
    public List<Course> selectAll() {
        List<Course> list=courseMapper.queryAllCourse();

        return list;
    }

    @Override
    public int deletCourseById(Course course) {

        return courseMapper.deleteByPrimaryKey(course);
    }

    @Override
    public List<Course> selectBycName(String cName) {

        return courseMapper.queryBycName("%"+cName+"%");
    }
}
