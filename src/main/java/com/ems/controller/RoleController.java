package com.ems.controller;

import com.ems.entity.SysEmployee;
import com.ems.entity.SysRole;
import com.ems.service.RoleService;
import com.ems.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/managerRoles")
public class RoleController {

    @Autowired
    RoleService roleService;

    @RequestMapping("/queryRole/{currentPage}")
    public String toIndex(@PathVariable("currentPage") String currentPage,  Model model){
        int currentPageIdx=Integer.parseInt(currentPage);
        int recordPerPage=8;//分页查询，每页查8个
        //获得本次分页查询所获得的列表
        List<SysRole> roles= roleService.queryRolesByPage(currentPageIdx,recordPerPage);
        //获得总记录数
        int totalRecordCount=roleService.getTotalCount();
        //计算总页数
        int totalPage=totalRecordCount%recordPerPage==0?totalRecordCount/recordPerPage :(totalRecordCount/recordPerPage)+1;
        //构造vo层对象
        PageBean<SysRole> pageBean=new PageBean<>();
        pageBean.setCurrentPageCode(currentPageIdx);

        pageBean.setTotalPageCode(totalPage);
        pageBean.setBeanList(roles);
        model.addAttribute("pageBean",pageBean);

        //forward跳转角色列表页面
        return "view/role/roleList";
    }
}
