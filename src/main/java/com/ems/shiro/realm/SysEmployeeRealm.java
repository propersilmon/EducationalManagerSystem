package com.ems.shiro.realm;

import com.ems.entity.SysEmployee;
import com.ems.entity.SysPermission;
import com.ems.entity.SysRole;
import com.ems.service.PermissionService;
import com.ems.service.RoleService;
import com.ems.service.TeacherService;
import com.ems.shiro.token.CustomizedToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SysEmployeeRealm extends AuthorizingRealm {

    @Autowired
    TeacherService teacherService;

    @Autowired
    RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("进行了教师权限的验证");
        SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
        int username = Integer.parseInt((String)principals.getPrimaryPrincipal());

        //List<SysRole>转List<String>
        List<SysRole> sysRoleList = roleService.queryRoleByEId(username);
        List<String> sysRoleStrList = new ArrayList<>();
        for(SysRole sysRole : sysRoleList){
            sysRoleStrList.add(sysRole.getrName());
        }

        //List<SysPermission>转List<String>
        List<SysPermission> sysPermissionList = permissionService.queryPermissionByUserId(username);
        List<String> sysPermissionStrList = new ArrayList<>();
        for(SysPermission sysPermission : sysPermissionList){
            sysRoleStrList.add(sysPermission.getpName());
        }

        //进行授权角色
        Set<String> roleSet = new HashSet<String>(sysRoleStrList);
        //进行授权权限
        Set<String> permissionSet = new HashSet<>(sysPermissionStrList);
        authorizationInfo.setRoles(roleSet);
        authorizationInfo.setStringPermissions(permissionSet);
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        SysEmployee sysEmployee = null;

        CustomizedToken customizedToken = (CustomizedToken)token;
        String username = customizedToken.getUsername();
        String password = new String((char[])token.getCredentials());

        sysEmployee = teacherService.queryByUsername(Integer.parseInt(username));

        if (sysEmployee == null){
            throw new UnknownAccountException();
        }

        if (!sysEmployee.getePassword().equals(password)){
            throw new IncorrectCredentialsException();
        }

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, password, getName());
        return info;
    }

    public void clearCached() {
        PrincipalCollection principals = SecurityUtils.getSubject()
                .getPrincipals();
        super.clearCache(principals);
    }
}
