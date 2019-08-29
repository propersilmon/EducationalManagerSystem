package com.ems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class TeacherController {
    @RequestMapping("")
    public  String seleteCourseAndClassPosition(HttpServletRequest req, HttpServletResponse resp , HttpSession session){


        return null;
    }
}
