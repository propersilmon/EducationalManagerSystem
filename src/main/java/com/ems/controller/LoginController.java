package com.ems.controller;

import com.ems.enumration.LoginType;
import com.ems.shiro.token.CustomizedToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {

    private static final String STUDENT_LOGIN_TYOPE = LoginType.STUDENT.toString();
    private static final String SYSEMPLOYEE_LOGIN_TYOPE = LoginType.SYSEMPLOYEE.toString();

    @RequestMapping("/student")
    public String studentLogin(@RequestParam("username") String username, @RequestParam("password") String password, Model model){
        Subject currentStudent = SecurityUtils.getSubject();
        if (!currentStudent.isAuthenticated()){
            CustomizedToken customizedToken = new CustomizedToken(username, password, STUDENT_LOGIN_TYOPE);
            try {
                currentStudent.login(customizedToken);
                return "student/index";
            }catch(AuthenticationException e){
                model.addAttribute("message", "用户名或密码错误");
            }
        }
        return "login/student";
    }

    @RequestMapping("/SysEmployee")
    public String sysEmployeeLogin(@RequestParam("username") String username, @RequestParam("password") String password, Model model){
        Subject currentSysEmployee = SecurityUtils.getSubject();
        if (!currentSysEmployee.isAuthenticated()){
            CustomizedToken customizedToken = new CustomizedToken(username, password, SYSEMPLOYEE_LOGIN_TYOPE);
            try {
                currentSysEmployee.login(customizedToken);
                return "sysEmployee/index";
            }catch(AuthenticationException e){
                model.addAttribute("message", "用户名或密码错误");
            }
        }
        return "login/sysEmployee";
    }
}
