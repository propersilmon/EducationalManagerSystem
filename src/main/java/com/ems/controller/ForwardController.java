package com.ems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ForwardController {

    @RequestMapping("/student/index")
    public String getStudentIndex(){
        return "view/student/index";
    }

    @RequestMapping("/sysEmployee/index")
    public String getSysEmployee(){
        return "view/sysEmployee/index";
    }


    @RequestMapping("/studentLogin")
    public String getStudentLogin(){
        return "view/login/studentLogin";
    }

    @RequestMapping("/sysEmployeeLogin")
    public String getSysEmployeeLogin(){
        return "view/login/sysEmployeeLogin";
    }

    @RequestMapping("/toIndex")
    public String getIndex(){
        return "index";
    }

    @RequestMapping("/unauthor")
    public String getUnauthor(){
        return "unauthor";
    }
}
