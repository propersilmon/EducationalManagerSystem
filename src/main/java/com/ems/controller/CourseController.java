package com.ems.controller;

import com.ems.entity.Course;
import com.ems.entity.CourseRoom;
import com.ems.entity.Room;
import com.ems.entity.SysEmployee;
import com.ems.mapper.ClassCourseMapper;
import com.ems.mapper.RoomMapper;
import com.ems.mapper.StudentCourseMapper;
import com.ems.service.CourseRoomService;
import com.ems.service.CourseService;
import com.ems.service.EmployeeService;
import com.ems.vo.Course_Teacher_RoomVoPoJO;
import com.ems.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
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
    @Autowired
    private CourseRoomService courseRoomService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private RoomMapper roomMapper;
    @Autowired
    private ClassCourseMapper classCourseMapper;

    @Autowired
    private StudentCourseMapper studentCourseMapper;

    @RequestMapping("/deletCourseById")
    public String deletCourseById(HttpServletRequest request, HttpServletResponse response) {
        Course c = new Course();
        c.setcId(Integer.parseInt(request.getParameter("cid")));
        courseService.deletCourseById(c);
        CourseRoom courseRoom = new CourseRoom();
        courseRoom.setcRId(Integer.parseInt(request.getParameter("crId")));
        courseRoomService.deleteCourseRoom(courseRoom);
        studentCourseMapper.deletbycId(Integer.parseInt(request.getParameter("cid")));
        classCourseMapper.deletbycId(Integer.parseInt(request.getParameter("cid")));
        return "redirect:/courseController/toListCourse";
    }

    @RequestMapping("/selectBycName")
    public String selectBycName(HttpServletRequest request, HttpServletResponse response, Model model) {
        PageBean<Course> pagebean = new PageBean<Course>();
        if (request.getParameter("cName") != null && !request.getParameter("cName").trim().equals("")) {
            pagebean = courseService.selectBycName(request.getParameter("cName"),
                    Integer.parseInt(request.getParameter("page")));
        } else {

            pagebean.setCurrentPageCode(Integer.parseInt(request.getParameter("page")));
            //获取当前数据的最大页数
            int maxPage = 1;
            if (courseService.getCount() % 8 == 0) {
                maxPage = courseService.getCount() / 8;
            } else {
                maxPage = courseService.getCount() / 8 + 1;
            }
            pagebean.setTotalPageCode(maxPage);
            pagebean = courseService.selectAll(pagebean);
        }

        List<Course_Teacher_RoomVoPoJO> course_teacher_roomVoPoJOS = queryEmpAndRoomByCourse(pagebean);

        model.addAttribute("ctroom", course_teacher_roomVoPoJOS);
        model.addAttribute("pagebean",pagebean);
        return "view/course/CourseList";
    }


    @RequestMapping("/addCourse")
    public String addCourse(HttpServletRequest request, HttpServletResponse response) {
        Course course = new Course();
//        获取的课程的字段，通过service添加到数据库

        course.setcName(request.getParameter("cName"));
        course.seteId(Integer.valueOf(request.getParameter("eId")));
        course.setElective(Byte.valueOf(request.getParameter("Elective")));
        course.setcCredit(Integer.valueOf(request.getParameter("cCredit")));
        course.setCreateDate(new Date());

        course = courseService.addCourse(course);

        CourseRoom courseRoom = new CourseRoom();
//         获取前端传来的教室信息，保存到数据库
        courseRoom.setcId(course.getcId());
        courseRoom.setEndWeek(request.getParameter("EndWeek"));
        courseRoom.setStartWeek(request.getParameter("StartWeek"));
        courseRoom.setWeek(request.getParameter("Week"));
        courseRoom.setrId(Integer.valueOf(request.getParameter("rId")));
        courseRoom.setInterval(request.getParameter("Interval"));
        courseRoom.setDesc(request.getParameter("Desc"));
        int flag = courseRoomService.insertSelective(courseRoom);
        return "redirect:/courseController/toListCourse";
    }

    @RequestMapping("toAddCourse")
    public String toAddCourse(Model model) {
        List<Room> rooms = roomMapper.queryAllRoom();
        List<SysEmployee> employees = employeeService.queryAll();
        model.addAttribute("rooms", rooms);
        model.addAttribute("Employees", employees);

        return "view/course/addCourse";
    }

    @RequestMapping("/toListCourse")
    public String toListCourse() {
        return "redirect:/courseController/selectBycName?page=1";
    }


    @RequestMapping("/updateCourse")
    public String updateCourse(HttpServletRequest request, HttpServletResponse response) {
        Course course = new Course();
//        获取的课程的字段，通过service添加到数据库

        course.setcName(request.getParameter("cName"));
        course.seteId(Integer.valueOf(request.getParameter("eId")));
        course.setElective(Byte.valueOf(request.getParameter("Elective")));
        course.setcCredit(Integer.valueOf(request.getParameter("cCredit")));
        course.setcId(Integer.valueOf(request.getParameter("cId")));

        int flag1 = courseService.updateCourse(course);

        CourseRoom courseRoom = new CourseRoom();
//         获取前端传来的教室信息，保存到数据库
        courseRoom.setcId(course.getcId());
        courseRoom.setcRId(Integer.valueOf(request.getParameter("crId")));
        courseRoom.setEndWeek(request.getParameter("EndWeek"));
        courseRoom.setStartWeek(request.getParameter("StartWeek"));
        courseRoom.setWeek(request.getParameter("Week"));
        courseRoom.setrId(Integer.valueOf(request.getParameter("rId")));
        int flag = courseRoomService.updateCourseRoom(courseRoom);


        return "redirect:/courseController/selectBycName?page=1";
    }

    @RequestMapping("/toUpdateCourse")
    public String toUpdate(HttpServletRequest request, HttpServletResponse response,Model model) {

        Course course=courseService.queryByKey(Integer.parseInt(request.getParameter("cid")));
        CourseRoom courseRoom=courseRoomService.selectByKey(Integer.valueOf(request.getParameter("crId")));
        model.addAttribute("course",course);
        model.addAttribute("courseRoom",courseRoom);
        List<Room> rooms = roomMapper.queryAllRoom();
        List<SysEmployee> employees = employeeService.queryAll();
        model.addAttribute("rooms", rooms);
        model.addAttribute("Employees", employees);
        return "view/course/update";
    }


    //---------------------------------------------------------------------------------------------------------------------------
    private List<Course_Teacher_RoomVoPoJO> queryEmpAndRoomByCourse(PageBean<Course> pageBean) {
        List<Course_Teacher_RoomVoPoJO> course_teacher_roomVoPoJOS = new ArrayList<>();
        for (Course course : pageBean.getBeanList()) {
            Course_Teacher_RoomVoPoJO course_teacher_roomVoPoJO = new Course_Teacher_RoomVoPoJO();
//            根据id中间表查询教师，教室封装到实体类集合中
            course_teacher_roomVoPoJO.setCourse(course);
            if (course.getcId() != null && course.getcId() != 0) {

                CourseRoom courseRooms = courseRoomService.selectByCId(course.getcId());
                course_teacher_roomVoPoJO.setCourseRooms(courseRooms);

                Room room = roomMapper.selectByPrimaryKey(courseRooms.getrId());
                course_teacher_roomVoPoJO.setRoom(room);

            }
            if (course.geteId() != null && course.geteId() != 0) {
                SysEmployee employee = employeeService.queryEmployeeById(course.geteId());
                course_teacher_roomVoPoJO.setSysEmployee(employee);
            }
            course_teacher_roomVoPoJOS.add(course_teacher_roomVoPoJO);
        }
        return course_teacher_roomVoPoJOS;
    }

}
