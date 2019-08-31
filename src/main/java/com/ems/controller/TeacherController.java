package com.ems.controller;

import com.ems.entity.Course;
import com.ems.entity.Student;
import com.ems.entity.SysEmployee;
import com.ems.service.TeacherService;
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
        int eId = 1;
        List<Course> courseList = teacherService.selectCNameByEId(eId);
        for (Course course:courseList) {
            System.out.println(course);
        }
        model.addAttribute("courseList",courseList);
        return "view/teacher/showStudents";
    }

    @RequestMapping("/selectStudents")
    public  String seleteStudentsByCId(HttpServletRequest req, HttpServletResponse resp , HttpSession session , Model model){
        int cId = 1;
        List<Student> studentList = teacherService.seleteStudentsByCId(cId);
        for (Student student:studentList) {
            System.out.println(student);
        }
        model.addAttribute("studentList",studentList);
        return null;
    }

    @RequestMapping("/select")
    public  String selectEmployeeByENameAndEPassword(HttpServletRequest req, HttpServletResponse resp , HttpSession session , Model model){
        String eName = "张三";
        String ePassword = "123";
        SysEmployee sysEmployee = teacherService.selectEmployeeByENameAndEPassword(eName,ePassword);
        System.out.println(sysEmployee);
        return null;
    }

}
