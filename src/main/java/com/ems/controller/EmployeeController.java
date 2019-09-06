package com.ems.controller;


import com.ems.entity.SysEmployee;
import com.ems.entity.SysRole;
import com.ems.service.EmployeeService;
import com.ems.service.PermissionService;
import com.ems.service.RoleService;
import com.ems.shiro.realm.SysEmployeeRealm;
import com.ems.vo.PageBean;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/employee")
@SessionAttributes("activeEmployee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private SysEmployeeRealm sysEmployeeRealm;


    /**
     * 跳转教职工登录页面
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String toLoginPage(){
        return "/employee/employeeLoginPage";
    }

    /**
     * 教职员工执行登录
     * @param employeeId
     * @param password
     * @param model
     * @return
     */
//    @RequestMapping(value = "/login",method = RequestMethod.POST)
//    public String login(@RequestParam("employeeId") String employeeId, @RequestParam("password") String password, Model model)
//    {
//        System.out.println("教职员工登录：工号"+employeeId+"密码"+password);
//        SysEmployee employee=employeeService.queryEmployeeById(Integer.parseInt(employeeId));
//        System.out.println(employee);
//        if(employee.getePassword().equals(password)){
//            ActiveEmployee activeEmployee=new ActiveEmployee();
//            // 查其的权限和菜单,进行set注入
//            List<SysPermission>  menuList =permissionService.queryMenuByUserId(employee.geteId());
//            List<SysPermission>  permissionList =permissionService.queryPermissionByUserId(employee.geteId());
//            activeEmployee.setEmployeeId(employee.geteId());
//            activeEmployee.setE_avg_score(employee.geteAvgScore());
//            activeEmployee.setEmployee_name(employee.geteName());
//            activeEmployee.setEployee_sex(employee.geteSex());
//            activeEmployee.setPassword(employee.getePassword());
//            activeEmployee.setMenuList(menuList);
//            activeEmployee.setPermissionList(permissionList);
//            model.addAttribute("activeEmployee",activeEmployee);
//            return "redirect:/employee/toHome";
//        }else{
//            model.addAttribute("message","账户名或密码错误");
//            return "/employee/employeeLoginPage";
//
//        }
//    }

    /**
     * 首次登入后台后展示的内容
     * @return
     */
    @RequestMapping("/toInnerIndex")
    public String toInnerIndex(){
        //todo 添加教务广播信息
        return "view/employee/innerIndex";
    }


    /**
     * 前往密码修改页面
     * @return
     */
    @RequestMapping(value = "/updatePassword",method = RequestMethod.GET )
    public String toUpdatePassword(){
        return "view/employee/updateCurrentEmployeePassword";
    }



    /**
     * 进行密码修改
     * @return
     */
    @RequestMapping(value = "/updatePassword",method = RequestMethod.POST )
    public String updatePassword(@RequestParam("newPassword") String newPassword, @RequestParam("employeeId")String employeeId ){
        System.out.println("修改密码的员工id是："+employeeId);
        System.out.println("新密码："+newPassword);
        int res= employeeService.updatePasswordByEmployeeId(Integer.parseInt(employeeId),newPassword);
        if(res>0) {
            return "redirect:/employee/updatePassword?isOk=true";
        }else{
            return "redirect:/employee/updatePassword?isOk=false";
        }
    }

    /**
     * 跳转到教职工主页
     * @return
     */
    @RequestMapping("/toHome")
    public String toHome(){
        return "view/employee/employeeHome";

    }

    /**
     *  注销当前员工，回到教务系统主页
     * @param session
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("activeEmployee");
        Subject currentEmployee = SecurityUtils.getSubject();
        currentEmployee.logout();
        sysEmployeeRealm.clearCached();
        //重定向在主页
        return "redirect:/toIndex";
    }


    //分配角色
    @RequestMapping("/updateRole")
    public String updateRole(HttpServletRequest req, HttpServletResponse resp){
        String currentPageCode = req.getParameter("currentPage");
        int eId = Integer.parseInt(req.getParameter("eId"));
        String[] roleArray = req.getParameterValues("alterRoles");
        employeeService.deleteRolesByeId(eId);
        if (roleArray == null){
            return "redirect:/employee/queryEmployee/" + currentPageCode;
        }
        for (String str : roleArray){
            int rId = Integer.parseInt(str);
            employeeService.addEmployeeRole(eId, rId);
        }
        return "redirect:/employee/queryEmployee/" + currentPageCode;
    }

    /**
     * 分页查询员工
     * @param currentPage
     * @return
     */
    @RequestMapping("/queryEmployee/{currentPage}")
    public String queryEmployeeByPage(@PathVariable("currentPage") String currentPage, Model model){
        int currentPageIdx=Integer.parseInt(currentPage);
        int recordPerPage=8;//分页查询，每页查8个
        //获得本次分页查询所获得的列表
        List<SysEmployee> employees= employeeService.queryEmployeeByPage(currentPageIdx,recordPerPage);
        //获得总记录数
        int totalRecordCount=employeeService.getTotalCount();
        //计算总页数
        int totalPage=totalRecordCount%recordPerPage==0?totalRecordCount/recordPerPage :(totalRecordCount/recordPerPage)+1;
        //构造vo层对象
        PageBean<SysEmployee> pageBean=new PageBean<>();
        pageBean.setCurrentPageCode(currentPageIdx);

        pageBean.setTotalPageCode(totalPage);
        pageBean.setBeanList(employees);
        model.addAttribute("pageBean",pageBean);

        //查询所有角色便于分配
        List<SysRole> roleList = roleService.queryAll();
        model.addAttribute("roleList", roleList);

        //forward跳转到员工列表页面
        return "view/employee/employeeList";
    }

    /**
     * 跳转到添加员工页面
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String toAddPage(){
        //forward跳转到添加员工页面
        return "view/employee/addEmployee";
    }

    /**
     * 添加员工
     * @param employee
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public String addEmployee(SysEmployee employee) {


        System.out.println("employeeId:"+employee.geteId());
        System.out.println("name:"+employee.geteName());
        System.out.println("password:"+employee.getePassword());
        System.out.println("sex:"+employee.geteSex());
        System.out.println("avgScore:"+employee.geteAvgScore());
        // 添加该用户，并返回该条记录的ID
        int res= employeeService.addEmployeeBackId(employee);
        if(res>0)
        {
            System.out.println("获得的工号是："+employee.geteId());
            return "<div class=\"mini-charts-item bgm-cyan\">\n" +
                    "                                    <div class=\"clearfix\">\n" +
                    "                                        <div class=\"chart stats-bar\">\n" +
                    "                                            <canvas width=\"83\" height=\"45\"\n" +
                    "                                                    style=\"display: inline-block; width: 83px; height: 45px; vertical-align: top;\"></canvas>\n" +
                    "                                        </div>\n" +
                    "                                        <div class=\"count\">\n" +
                    "                                            <small>添加成功:分配工号如下</small>\n" +
                    "                                            <h2>"+employee.geteId()+"</h2>\n" +
                    "                                        </div>\n" +
                    "                                    </div>\n" +
                    "                                </div>";
        }else{
            return "<div class=\"mini-charts-item bgm-cyan\">\n" +
                    "                                    <div class=\"clearfix\">\n" +
                    "                                        <div class=\"chart stats-bar\">\n" +
                    "                                            <canvas width=\"83\" height=\"45\"\n" +
                    "                                                    style=\"display: inline-block; width: 83px; height: 45px; vertical-align: top;\"></canvas>\n" +
                    "                                        </div>\n" +
                    "                                        <div class=\"count\">\n" +
                    "                                            <small>未能添加成功</small>\n" +
                    "                                            <h2></h2>\n" +
                    "                                        </div>\n" +
                    "                                    </div>\n" +
                    "                                </div>";
        }


    }
}
