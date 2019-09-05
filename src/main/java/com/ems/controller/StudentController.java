package com.ems.controller;

import com.ems.entity.Student;
import com.ems.entity.StudentCourse;
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
