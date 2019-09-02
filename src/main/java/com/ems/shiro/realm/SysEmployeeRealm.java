package com.ems.shiro.realm;

import com.ems.entity.SysEmployee;
import com.ems.service.TeacherService;
import com.ems.shiro.token.CustomizedToken;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class SysEmployeeRealm extends AuthorizingRealm {

    @Autowired
    TeacherService teacherService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("进行了教师权限的验证");
        SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
        //进行授权角色
        Set<String> roleSet = new HashSet<>();
        roleSet.add("admin");
        authorizationInfo.setRoles(roleSet);
        Set<String> permissionSet = new HashSet<>();
        //进行授权权限
        permissionSet.add("user:delete");
        permissionSet.add("user:update");
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
}
