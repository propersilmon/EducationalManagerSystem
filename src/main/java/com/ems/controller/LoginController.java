package com.ems.controller;

import com.ems.entity.Student;
import com.ems.entity.SysEmployee;
import com.ems.entity.SysPermission;
import com.ems.enumration.LoginType;
import com.ems.service.EmployeeService;
import com.ems.service.PermissionService;
import com.ems.service.StudentSerivce;
import com.ems.shiro.token.CustomizedToken;
import com.ems.vo.ActiveEmployee;
import com.ems.vo.ActiveStudent;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@RequestMapping("/login")
@SessionAttributes( value = {"activeEmployee", "activeStudent"})
public class LoginController {

    private static final String STUDENT_LOGIN_TYOPE = LoginType.STUDENT.toString();
    private static final String SYSEMPLOYEE_LOGIN_TYOPE = LoginType.SYSEMPLOYEE.toString();

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private StudentSerivce studentSerivce;

    @RequestMapping("/student")
    public String studentLogin(@RequestParam("username") String username, @RequestParam("password") String password, Model model){
        System.out.println("进行了学生登录");
        Subject currentStudent = SecurityUtils.getSubject();
        if (!currentStudent.isAuthenticated()){
            CustomizedToken customizedToken = new CustomizedToken(username, password, STUDENT_LOGIN_TYOPE);
            try {
                currentStudent.login(customizedToken);

                //将当前登录对象插入到HttpSession中
                Student student = studentSerivce.queryStudentById(username);
                ActiveStudent activeStudent = new ActiveStudent();
                activeStudent.setsClass(student.getsClass());
                activeStudent.setsStartYear(student.getsStartYear());
                activeStudent.setsEndYear(student.getsEndYear());
                activeStudent.setsId(student.getsId());
                activeStudent.setsSex(student.getsSex());
                activeStudent.setsName(student.getsName());
                activeStudent.setsState(student.getsState());

                model.addAttribute("activeStudent", activeStudent);
                return "view/student/index";
            }catch(AuthenticationException e){
                model.addAttribute("message", "用户名或密码错误");
            }
        }
        return "view/login/studentLogin";
    }

    @RequestMapping("/SysEmployee")
    public String sysEmployeeLogin(@RequestParam("username") String username, @RequestParam("password") String password, Model model){
        System.out.println("进行教职工登录");
        Subject currentSysEmployee = SecurityUtils.getSubject();
        if (!currentSysEmployee.isAuthenticated()){
            CustomizedToken customizedToken = new CustomizedToken(username, password, SYSEMPLOYEE_LOGIN_TYOPE);
            try {
                currentSysEmployee.login(customizedToken);

                //若login成功则将当前登录对象加入到HttpSession中
                SysEmployee employee=employeeService.queryEmployeeById(Integer.parseInt(username));
                ActiveEmployee activeEmployee=new ActiveEmployee();
                // 查其的权限和菜单,进行set注入
                List<SysPermission> menuList =permissionService.queryMenuByUserId(employee.geteId());
                List<SysPermission>  permissionList =permissionService.queryPermissionByUserId(employee.geteId());
                activeEmployee.setEmployeeId(employee.geteId());
                activeEmployee.setE_avg_score(employee.geteAvgScore());
                activeEmployee.setEmployee_name(employee.geteName());
                activeEmployee.setEployee_sex(employee.geteSex());
                activeEmployee.setPassword(employee.getePassword());
                activeEmployee.setMenuList(menuList);
                activeEmployee.setPermissionList(permissionList);
                model.addAttribute("activeEmployee",activeEmployee);

                return "redirect:/employee/toHome";
            }catch(AuthenticationException e){
                model.addAttribute("message", "用户名或密码错误");
            }
        }
        return "view/login/sysEmployeeLogin";
    }
}
