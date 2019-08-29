package com.ems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ForwardController {

    @RequestMapping("/view/welcome")
    public String getWelcome(){
        return "view/welcome";
    }

    @RequestMapping("/login")
    public void getLogin(){
        System.out.println("login");
    }
}
