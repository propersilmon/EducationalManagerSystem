package com.ems.controller;

import com.ems.entity.Course;
import com.ems.entity.CourseRoom;
import com.ems.entity.SysEmployee;
import com.ems.service.CourseRoomService;
import com.ems.service.CourseService;
import com.ems.service.EmployeeService;
import com.ems.service.impl.CourseRoomServicImpl;
import com.ems.service.impl.EmployeeServiceImpl;
import com.ems.vo.Course_Teacher_RoomVoPoJO;
import com.ems.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
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
    private CourseService courseService;
    private CourseRoomService courseRoomService =new CourseRoomServicImpl();
    private EmployeeService employeeService=new EmployeeServiceImpl();
    private  static List<Course_Teacher_RoomVoPoJO> course_teacher_roomVoPoJOS=new ArrayList<>();
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
        for (Course course:pageBean.getBeanList()){
//            根据id中间表查询教师，教室封装到实体类集合中
            Course_Teacher_RoomVoPoJO course_teacher_roomVoPoJO=new Course_Teacher_RoomVoPoJO();
            course_teacher_roomVoPoJO.setCourse(course);

            List<CourseRoom> courseRooms=courseRoomService.selectByCId(course.getcId());
            course_teacher_roomVoPoJO.setCourseRooms(courseRooms);
            SysEmployee employee=employeeService.queryEmployeeById(course.geteId());
            course_teacher_roomVoPoJO.setSysEmployee(employee);
            course_teacher_roomVoPoJOS.add(course_teacher_roomVoPoJO);
        }
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
