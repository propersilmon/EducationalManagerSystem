package com.ems.controller;

import com.ems.entity.Student;
import com.ems.service.StudentSerivce;
import com.ems.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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


}
