package com.ems.shiro.realm;

import com.ems.entity.Student;
import com.ems.service.StudentSerivce;
import com.ems.shiro.token.CustomizedToken;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentRealm extends AuthorizingRealm {

    @Autowired
    StudentSerivce studentSerivce;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        Student student = null;

        CustomizedToken customizedToken = (CustomizedToken)token;
        String username = customizedToken.getUsername();
        String password = new String((char[])token.getCredentials());

        //TODO:通过StudentService中查询对应username的账户和密码
        student = studentSerivce.queryStudentById(username);

        if (student == null){
            throw new UnknownAccountException();
        }

        //TODO:通过查询后的student来获取密码;
        if (!student.getsPassword().equals(password)){
            throw new IncorrectCredentialsException();
        }

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, password, getName());
        return info;
    }
}
