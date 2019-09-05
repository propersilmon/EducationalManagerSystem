package com.ems.controller;

import com.ems.entity.Student;
import com.ems.service.StudentSerivce;
import com.ems.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @program: hqyj_edu_managerSystem_ssm->ManagerStudentController
 * @description: 教务处对学生学籍的管理
 * @author: ty
 * @create: 2019-09-03 10:56
 **/
@Controller
@RequestMapping("/managerStudent")
public class ManagerStudentController {
    @Autowired
    private StudentSerivce studentService;

    /**
     * 教务处分页查询所有在籍学生
     * @param currentPage
     * @param model
     * @return
     */
    @RequestMapping("/queryStudent/{currentPage}")
    public String queryAllStudentByPage(@PathVariable("currentPage")int currentPage, Model model){
        int recordPerPage=8;
        List<Student> studentList= studentService.queryByPage(currentPage,recordPerPage);
        int totalStudentCount=studentService.totalStudentCount();
        int totalPageCount=totalStudentCount%recordPerPage==0?totalStudentCount/recordPerPage:(totalStudentCount/recordPerPage)+1;//计算总页数
        PageBean<Student> pageBean=new PageBean<>();
        pageBean.setBeanList(studentList);
        pageBean.setTotalPageCode(totalPageCount);
        pageBean.setCurrentPageCode(currentPage);
        model.addAttribute("pageBean",pageBean);
        return "view/employee/managerStudent/studentList";
    }

    /**
     * 开除学籍
     * @param sid
     * @return
     */
    @RequestMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("sid")String sid)
    {
        int res= studentService.delteStudentById(sid);
        if(res>0)
        {
            return "redirect:/managerStudent/queryStudent/1";
        }else{
            //todo 处理开除失败的情况
            return "";
        }
    }

    /**
     * 前往注册学籍页面
     * @return
     */
    @RequestMapping(value = "/addStudent",method = RequestMethod.GET)
    public String toAddStudent(){
        return "view/employee/managerStudent/addStudent";
    }

    /**
     * 执行学籍注册
     * @param student
     * @return
     */
    @RequestMapping(value = "/addStudent",method = RequestMethod.POST)
    public String addStudent(Student student){
        student.setsPassword("123456");//设置默认密码
        student.setsState("在籍");//设置默认状态
        System.out.println(student);
        // 数据库操作
        int res=studentService.addStudent(student);
        if(res>0)
        {
            return "redirect:/managerStudent/queryStudent/1";
        }else{
            //todo 未处理成功的时跳转到错误页面
            return "";
        }

    }

    /**
     * 执行更改学生信息
     * @param student
     * @return
     */
    @RequestMapping("/updateStudent")
    public String updateStudent(Student student){
        System.out.println("更改的学生"+student);
        int res= studentService.updateStudentByStudent(student);
        if(res>0)
        {
            return "redirect:/managerStudent/queryStudent/1";
        }else{
            return "";
        }

    }
}
