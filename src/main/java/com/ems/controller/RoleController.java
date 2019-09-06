package com.ems.controller;

import com.ems.entity.SysEmployee;
import com.ems.entity.SysPermission;
import com.ems.entity.SysRole;
import com.ems.service.PermissionService;
import com.ems.service.RoleService;
import com.ems.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/managerRoles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/queryRole/{currentPage}")
    public String toIndex(@PathVariable("currentPage") String currentPage,  Model model){
        int currentPageIdx=Integer.parseInt(currentPage);
        int recordPerPage=8;//分页查询，每页查8个
        //获得本次分页查询所获得的列表
        List<SysRole> roles= roleService.queryRolesByPage(currentPageIdx,recordPerPage);
        //获得总记录数
        int totalRecordCount=roleService.getTotalCount();
        //计算总页数
        int totalPage = 0;
        if (totalRecordCount < recordPerPage){
            totalPage = 1;
        }else{
            totalPage=totalRecordCount%recordPerPage==0?totalRecordCount/recordPerPage :(totalRecordCount/recordPerPage)+1;
        }
        //构造vo层对象
        PageBean<SysRole> pageBean=new PageBean<>();
        pageBean.setCurrentPageCode(currentPageIdx);

        pageBean.setTotalPageCode(totalPage);
        pageBean.setBeanList(roles);
        model.addAttribute("pageBean",pageBean);

        //查询所有权限便于分配
        List<SysPermission> permissionList = permissionService.queryAll();
        model.addAttribute("permissionList", permissionList);

        //forward跳转角色列表页面
        return "view/role/roleList";
    }

    //添加角色
    @RequestMapping("/addRole")
    public String addRole(HttpServletRequest req, HttpServletResponse resp, Model model){
        String roleName = req.getParameter("roleName");
        String desc = req.getParameter("desc");
        roleService.addRole(roleName, desc);
        return "redirect:/managerRoles/queryRole/1";
    }

    //修改角色
    @RequestMapping("/alterRole")
    public String alterRole(HttpServletRequest req, HttpServletResponse resp){
        String currentPageCode = req.getParameter("currentPage");
        String rIdStr = req.getParameter("rId");
        int rId = Integer.parseInt(rIdStr);
        String roleName = req.getParameter("roleName");
        String desc = req.getParameter("desc");
        SysRole sysRole = new SysRole(rId, roleName, desc);
        roleService.alterRole(sysRole);
        return "redirect:/managerRoles/queryRole/" + currentPageCode;
    }

    //删除角色
    @RequestMapping("/deleteRole")
    public String deleteRole(HttpServletRequest req){
        String currentPageCode = req.getParameter("currentPage");
        String rIdStr = req.getParameter("rId");
        int rId = Integer.parseInt(rIdStr);
        roleService.deleteRoleByrId(rId);
        return "redirect:/managerRoles/queryRole/" + currentPageCode;
    }

    //分配权限
    @RequestMapping("/dividePermission")
    public String dividePermission(HttpServletRequest req){
        String currentPageCode = req.getParameter("currentPage");
        String rIdStr = req.getParameter("rId");
        int rId = Integer.parseInt(rIdStr);
        String[] permissionArray = req.getParameterValues("dPermissions");
        roleService.deletePermissionByrId(rId);
        if (permissionArray == null){
            return "redirect:/managerRoles/queryRole/" + currentPageCode;
        }
        for(String str : permissionArray){
            int pId = Integer.parseInt(str);
            roleService.addPermission(rId, pId);
        }
        return "redirect:/managerRoles/queryRole/" + currentPageCode;


//        String currentPageCode = req.getParameter("currentPage");
//        int eId = Integer.parseInt(req.getParameter("eId"));
//        String[] roleArray = req.getParameterValues("alterRoles");
//        employeeService.deleteRolesByeId(eId);
//        for (String str : roleArray){
//            int rId = Integer.parseInt(str);
//            employeeService.addEmployeeRole(eId, rId);
//        }
//        String toEmployeeList = "redirect:/employee/queryEmployee/" + currentPageCode;
//        return toEmployeeList;
    }
}
