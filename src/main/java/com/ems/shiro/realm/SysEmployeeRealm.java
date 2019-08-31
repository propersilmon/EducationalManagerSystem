package com.ems.shiro.realm;

import com.ems.entity.SysEmployee;
import com.ems.shiro.token.CustomizedToken;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashSet;
import java.util.Set;

public class SysEmployeeRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("进行了权限的验证");
        //获取用户名
        String userName=(String)principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
        //进行授权角色
        Set<String> roleSet = new HashSet<>();
        roleSet.add("admin");
        authorizationInfo.setRoles(roleSet);
        Set<String> permissionSet = new HashSet<>();
        permissionSet.add("user:delete");
        permissionSet.add("user:update");
        //进行授权权限
        authorizationInfo.setStringPermissions(permissionSet);
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        SysEmployee sysEmployee = null;

        CustomizedToken customizedToken = (CustomizedToken)token;
        String username = customizedToken.getUsername();
        String password = new String((char[])token.getCredentials());

        System.out.println(sysEmployee);
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
