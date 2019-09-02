package com.ems.service.impl;

import com.ems.entity.Course;
import com.ems.mapper.CourseMapper;
import com.ems.service.CourseService;
import com.ems.vo.PageBean;
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
    public Course addCourse(Course course) {
        int cId= courseMapper.addCourse(course);
        if (cId != 0){
            return course;
        }
        else
            return null;
    }

    @Override
    public int updateCourse(Course course) {
        return 0;
    }

    @Override
    public PageBean<Course> selectAll(PageBean<Course> pageBean) {
        List<Course> list = courseMapper.queryAllCourse((pageBean.getCurrentPageCode()-1)*10);
        pageBean.setBeanList(list);
        return pageBean;
    }

    @Override
    public int deletCourseById(Course course) {

        return courseMapper.deleteByPrimaryKey(course);
    }

    @Override
    public PageBean<Course>  selectBycName(String cName , int Npage) {
        PageBean<Course> pageBean=new PageBean<>();
        pageBean.setCurrentPageCode(Npage);
        int maxPage=0;
        if (courseMapper.queryBycNameCount()%10==0){
            maxPage=courseMapper.queryBycNameCount()/10;
        }else{
            maxPage=courseMapper.queryBycNameCount()/10+1;
        }
        pageBean.setTotalPageCode(maxPage);
        pageBean.setBeanList(courseMapper.queryBycName("%"+cName+"%",(Npage-1)*10));
        return pageBean;
    }

    @Override
    public int getCount() {

        return courseMapper.queryCourseCount();
    }
}
