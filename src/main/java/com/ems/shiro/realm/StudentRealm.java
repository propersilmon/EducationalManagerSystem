package com.ems.shiro.realm;

import com.ems.entity.Student;
import com.ems.service.StudentSerivce;
import com.ems.shiro.token.CustomizedToken;
import org.apache.shiro.SecurityUtils;
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
        return null;
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

    public void clearCached() {
        PrincipalCollection principals = SecurityUtils.getSubject()
                .getPrincipals();
        super.clearCache(principals);
    }
}
