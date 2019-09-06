package com.ems.controller;

import com.ems.entity.*;
import com.ems.service.StudentSerivce;
import com.ems.vo.ActiveStudent;
import com.ems.vo.PageBean;
import com.ems.vo.StudentChoseCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentSerivce studentSerivce;

    @RequestMapping("/queryAll/{currentPage}")
    public String queryStudentByPage(@PathVariable("currentPage") String currentPage, Model model){
        //目前分页页数定为10
        int currentPageIdx=Integer.parseInt(currentPage);
        List<Student> students= studentSerivce.queryStudentByPage(currentPageIdx);
        int totalStudentCount= studentSerivce.totalStudentCount();
        int totalPage=totalStudentCount%10==0?totalStudentCount/10:(totalStudentCount/10)+1;//算的总页数
        PageBean<Student> pageBean=new PageBean<Student>();
        pageBean.setBeanList(students);
        pageBean.setCurrentPageCode(currentPageIdx);
        model.addAttribute("pageBean",pageBean);
        //todo 页面跳转
        return "";

    }
    @RequestMapping("/addStudent")
    public String addStudent(@RequestParam("studentId") String id,@RequestParam("studentName") String studentName,@RequestParam("password") String password,
    @RequestParam("sex") String sex,@RequestParam("startYear") String startYear,@RequestParam("endYear") String endYear,@RequestParam("clazz") String clazz,@RequestParam("state") String state){
//        添加新学生
        Student student=new Student();
        student.setsId(id);
        student.setsName(studentName);
        student.setsClass(clazz);
        student.setsPassword(password);
        student.setsSex(sex);
        student.setsStartYear(startYear);
        student.setsEndYear(endYear);
        student.setsState(state);
        int res= studentSerivce.addStudent(student);
        if(res>0){
            return "";//todo 重定向到/queryAll/${currentPage}
        }else{
            return "";//todo 跳转到本页面，显示错误信息
        }


    }

    @RequestMapping("/updateStudent")
    public String updateStudent(@RequestParam("studentId") String id,@RequestParam("studentName") String studentName,@RequestParam("password") String password,
                             @RequestParam("sex") String sex,@RequestParam("startYear") String startYear,@RequestParam("endYear") String endYear,@RequestParam("clazz") String clazz,@RequestParam("state") String state){
//
        Student student=new Student();
        student.setsId(id);
        student.setsName(studentName);
        student.setsClass(clazz);
        student.setsPassword(password);
        student.setsSex(sex);
        student.setsStartYear(startYear);
        student.setsEndYear(endYear);
        student.setsState(state);
        int res= studentSerivce.updateStudentByStudent(student);
        if(res>0){
            return "";//todo 重定向到/queryAll/${currentPage}
        }else{
            return "";//todo 跳转到本页面，显示错误信息
        }


    }

    @RequestMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("studentId") String id){
//        添加新学生

        int res= studentSerivce.delteStudentById(id);
        if(res>0){
            return "";//todo 重定向到/queryAll/${currentPage}
        }else{
            return "";//todo 跳转到本页面，显示错误信息
        }


    }
    /**
     * author:Chung-HB
     */
    //查询所有的必修课
    @RequestMapping("/queryBXCourse")
    public String queryBXCourse(HttpServletRequest req, HttpServletResponse resp, Model model,
                                Student student) throws IOException {
        ActiveStudent activeStudent = (ActiveStudent) req.getSession().getAttribute("activeStudent");
        String  sClass=activeStudent.getsClass();
        List<ClassCourse> BXCourse = studentSerivce.queryAllBXCourse(sClass);
        List<ClassCourse> YXXXCourse = null;
        for (ClassCourse classcourse : BXCourse) {
            int cId = classcourse.getcId();
            YXXXCourse = studentSerivce.queryBXByID(cId);
        }
        req.setAttribute("YXXXCourse", YXXXCourse);
        // 2、跳转页面
        return "view/student/studentBXList";
    }

    @RequestMapping("/updateBXCourse")
    //添加必修课到选课表
    public String updateBXCourse(HttpServletRequest req, HttpServletResponse resp, Model model,
                                 Student student) throws IOException {
        ActiveStudent activeStudent = (ActiveStudent) req.getSession().getAttribute("activeStudent");
        String  sClass=activeStudent.getsClass();
        List<ClassCourse> BXCourse = studentSerivce.queryAllBXCourse(sClass);
        for (ClassCourse classcourse : BXCourse) {
            classcourse.getcId();
            StudentCourse studentCourse = new StudentCourse();
            studentCourse.setcId(classcourse.getcId());
            studentCourse.setsId(activeStudent.getsId());
            int n=studentSerivce.delteXK(studentCourse);
            int m=studentSerivce.addAllBXCourse(studentCourse);
            System.out.println(n+"################"+m);
        }

        return "view/student/index";
    }

    //查询所有的选修课
    @RequestMapping("/queryAllXXCourse")
    public String queryAllXXCourse(HttpServletRequest request, HttpServletResponse resp, Model model,
                                   Student student) throws IOException {
        System.out.println("##############################");
        List<Course> list=studentSerivce.queryAllXXCourse();
        for (Course course : list) {
            System.out.println(course.toString());
        }
        request.setAttribute("list", list);
        return"view/student/studentXXList";
    }

    //查询所有的课程
    @RequestMapping("/queryAllCourse")
    public String queryAllCourse(HttpServletRequest request, HttpServletResponse resp, Model model,
                                 Student student ,HttpSession session) throws IOException {
        System.out.println("##############################");
        ActiveStudent activeStudent = (ActiveStudent) request.getSession().getAttribute("activeStudent");
        String sId=activeStudent.getsId();
        //查询所有的课程
        List<Course> allCourse=studentSerivce.queryAllCourse1(sId);
        List<Course> all=studentSerivce.queryAllC();
        //查询所有的教室
        List<CourseRoom> list = studentSerivce.queryAllCR(sId);
        //查询所有的Room
        List<Room>list1=studentSerivce.queryAllRoom1();
        model.addAttribute("list",list);
        model.addAttribute("list1",list1);
        model.addAttribute("all",all);
        request.setAttribute("allCourse", allCourse);
        return"view/student/studentAllCourseList";
    }

    //添加选修课
    @RequestMapping("/addXXCourse")
    public String addXXCourse(HttpServletRequest request, HttpServletResponse resp, Model model,
                              Student student) throws IOException {

        ActiveStudent activeStudent = (ActiveStudent) request.getSession().getAttribute("activeStudent");
        String sId=activeStudent.getsId();
        String []cId_st= request.getParameterValues("selectCourse");
        for(String temp : cId_st) {
            int cId = Integer.valueOf(temp);
            StudentCourse studentCourse = new StudentCourse();
            studentCourse.setsId(sId);
            studentCourse.setcId(cId);
            int n = studentSerivce.delteXX(studentCourse);
            int m = studentSerivce.addXXcourse(studentCourse);
        }
        return "view/student/index";
    }

    /*退课*/
    @RequestMapping(value = "/deleteCourse")
    public String deleteCourse(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        String sCIdStr = request.getParameter("sCId");
        int sCId= Integer.parseInt(sCIdStr);

        ActiveStudent activeStudent = (ActiveStudent)session.getAttribute("activeStudent");
        String sId = activeStudent.getsId();
        int n = studentSerivce.dropCourseCourseByS_c_id(sCId);
        System.out.println(n);


        if(n>0){
            return "redirect:/student/queryChoseCourse";//todo 重定向到/queryChoseCourse/${currentPage}
        }else{
            return "view/studentCourse/studentChoseList";//todo 跳转到本页面，显示错误信息
        }
    }
    /*查看选课情况*/
    @RequestMapping(value = "/queryChoseCourse")
    public String queryChoseCourse(HttpServletRequest request, HttpServletResponse response, HttpSession session,Model model){
        ActiveStudent activeStudent = (ActiveStudent)session.getAttribute("activeStudent");
        String sId = activeStudent.getsId();
        List<StudentChoseCourse> studentCourseList =studentSerivce.queryAllStudentCourseByS_id(sId);
        model.addAttribute("studentCourseList",studentCourseList);
        return "view/studentCourse/studentChoseList";
    }
    /*评教*/
    @RequestMapping(value = "/evaluationTeaching")
    public String evaluationTeaching(HttpServletRequest request, HttpServletResponse response,HttpSession session){
        ActiveStudent activeStudent = (ActiveStudent)session.getAttribute("activeStudent");
        String sId = activeStudent.getsId();
        String sCIdStr = request.getParameter("sCId");
        int sCId= Integer.parseInt(sCIdStr);
        String tScoreStr = request.getParameter("tScore");
        int tScore = Integer.parseInt(tScoreStr);
        int n = studentSerivce.updateT_scoreByS_c_id(tScore,sCId);
        if(n>0){
            return "redirect:/student/queryChoseCourse";//todo 重定向到/queryChoseCourse/${currentPage}
        }else{
            return "view/studentCourse/studentChoseList";//todo 跳转到本页面，显示错误信息


        }
    }
}
