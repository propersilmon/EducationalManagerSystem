package com.ems.service;

import com.ems.entity.Course;
import com.ems.vo.PageBean;

public interface CourseService {
    Course addCourse(Course course);
    int updateCourse(Course course);
    PageBean<Course> selectAll(PageBean<Course> pageBean);
    int deletCourseById(Course course);
    PageBean<Course>  selectBycName(String cName,int Npage);
    int getCount();
    Course queryByKey(int cId);
}
