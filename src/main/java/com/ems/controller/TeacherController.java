package com.ems.controller;

import com.ems.entity.Course;
import com.ems.entity.Student;
import com.ems.service.TeacherService;
import com.ems.vo.ActiveEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/teacherController")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/updateUI")
    public  String seleteCourseToUodateUI(HttpServletRequest req, HttpServletResponse resp , HttpSession session , Model model){
        ActiveEmployee activeEmployee = (ActiveEmployee) session.getAttribute("activeEmployee");
        int eId = activeEmployee.getEmployeeId();
        List<Course> courseList = teacherService.selectCNameByEId(eId);
        for (Course course:courseList) {
            System.out.println(course);
        }
        model.addAttribute("courseList",courseList);
        return "view/teacher/showStudents";
    }

    @RequestMapping("/selectStudents")
    public  String seleteStudentsByCId(HttpServletRequest req, HttpServletResponse resp , HttpSession session , Model model){
        int cId = Integer.parseInt(req.getParameter("cId"));
        ActiveEmployee activeEmployee = (ActiveEmployee) session.getAttribute("activeEmployee");
        int eId = activeEmployee.getEmployeeId();
        List<Course> courseList = teacherService.selectCNameByEId(eId);
        List<Student> studentList = teacherService.seleteStudentsByCId(cId);
        for (Student student:studentList) {
            System.out.println(student);
        }
        model.addAttribute("studentList",studentList);
        model.addAttribute("courseList",courseList);
        return "view/teacher/showStudents";
    }



}
