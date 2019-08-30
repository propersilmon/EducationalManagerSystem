package com.ems.controller;

import com.ems.entity.Course;
import com.ems.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @program: EMS->CourseController
 * @description:
 * @author: lyl
 * @create: 2019-08-30 15:51
 **/
@Controller
@RequestMapping("/courseController")
public class CourseController {
    @Autowired
    CourseService courseService;

    @RequestMapping("/queryAll")
    public String queryAll(){
        List<Course> list=courseService.selectAll();
        System.out.println(list);
        return null;

    }
    @RequestMapping("/deletCourseById")
    public String deletCourseById(HttpServletRequest request, HttpServletResponse response){
        Course c=new Course();
        c.setcId(Integer.parseInt(request.getParameter("cid")));
        courseService.deletCourseById(c);
        return null;
    }
    @RequestMapping("/selectBycName")
    public String selectBycName(HttpServletRequest request, HttpServletResponse response){
        List<Course> list=courseService.selectBycName(request.getParameter("cName"));
        System.out.println(list);
        return null;
    }
}
