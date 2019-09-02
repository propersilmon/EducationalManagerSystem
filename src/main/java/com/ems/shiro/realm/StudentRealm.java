package com.ems.shiro.realm;

import com.ems.entity.Student;
import com.ems.service.StudentSerivce;
import com.ems.shiro.token.CustomizedToken;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class StudentRealm extends AuthorizingRealm {

    @Autowired
    StudentSerivce studentSerivce;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        System.out.println("进行了学生的认证");
        String userName = (String)principals.getPrimaryPrincipal();
        //进行授权角色
        Set<String> roleSet = new HashSet<>();
        roleSet.add("student");
        info.setRoles(roleSet);
        Set<String> permissionSet = new HashSet<>();
        //进行授权权限
        permissionSet.add("user:delete");
        info.setStringPermissions(permissionSet);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        Student student = null;

        CustomizedToken customizedToken = (CustomizedToken)token;
        String username = customizedToken.getUsername();
        String password = new String((char[])token.getCredentials());

        student = studentSerivce.queryStudentById(username);

        if (student == null){
            throw new UnknownAccountException();
        }

        if (!student.getsPassword().equals(password)){
            throw new IncorrectCredentialsException();
        }

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, password, getName());
        return info;
    }
}
