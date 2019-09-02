package com.ems.controller;

import com.ems.entity.Course;
import com.ems.service.CourseService;
import com.ems.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    public String queryAll(HttpServletRequest request, HttpServletResponse response, Model model) {
        PageBean<Course> pageBean = new PageBean<>();
        pageBean.setCurrentPageCode(Integer.parseInt(request.getParameter("page")));
        //获取当前数据的最大页数
        int maxPage = 0;
        if (courseService.getCount() % 10 == 0) {
            maxPage = courseService.getCount() / 10;
        } else {
            maxPage = courseService.getCount() / 10 + 1;
        }

        pageBean.setTotalPageCode(maxPage);
        pageBean = courseService.selectAll(pageBean);
        System.out.println(pageBean.getBeanList());
        System.out.println(pageBean.getTotalPageCode());
//        将数据传到model中
        model.addAttribute("pageBean", pageBean);
//        返回跳转页面的url
        return null;

    }

    @RequestMapping("/deletCourseById")
    public String deletCourseById(HttpServletRequest request, HttpServletResponse response) {
        Course c = new Course();
        c.setcId(Integer.parseInt(request.getParameter("cid")));
        courseService.deletCourseById(c);
        return null;
    }

    @RequestMapping("/selectBycName")
    public String selectBycName(HttpServletRequest request, HttpServletResponse response) {
        PageBean<Course> pagebean=new PageBean<Course>();
        if (request.getParameter("cName") != null && !request.getParameter("cName").trim().equals("")) {
            pagebean = courseService.selectBycName(request.getParameter("cName"),
                    Integer.parseInt(request.getParameter("page")));
        }else {
            pagebean.setCurrentPageCode(Integer.parseInt(request.getParameter("page")));
            //获取当前数据的最大页数
            int maxPage = 0;
            if (courseService.getCount() % 10 == 0) {
                maxPage = courseService.getCount() / 10;
            } else {
                maxPage = courseService.getCount() / 10 + 1;
            }

            pagebean.setTotalPageCode(maxPage);
            pagebean = courseService.selectAll(pagebean);
        }
        System.out.println(pagebean.getBeanList());
        return null;
    }

    @RequestMapping("/addCourse")
    public String addCourse(HttpServletRequest request, HttpServletResponse response) {
        Course course = new Course();
        course.setcName(request.getParameter("cName"));
        course.seteId(Integer.valueOf(request.getParameter("eId")));
        course.setElective(Byte.valueOf(request.getParameter("Elective")));
        course = courseService.addCourse(course);

        System.out.println(course);
        return null;
    }
}
