package com.ems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ForwardController {

    @RequestMapping("/view/welcome")
    public String getWelcome(){
        return "view/welcome";
    }

    @RequestMapping("/studentLogin")
    public String getStudentLogin(){
        return "view/login/studentLogin";
    }

    @RequestMapping("/sysEmployeeLogin")
    public String getSysEmployeeLogin(){
        return "view/login/sysEmployeeLogin";
    }

    @RequestMapping("/index")
    public String getIndex(){
        return "index.jsp";
    }
}
