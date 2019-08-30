package com.ems.realm;

import com.ems.entity.SysEmployee;
import com.ems.service.TeacherService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class TeacherRealm extends AuthorizingRealm {

    @Autowired
    TeacherService teacherService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //TODO:对教师角色进行装配
        return null;
//        //获取用户名
//		String userName=(String)principals.getPrimaryPrincipal();
//		SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
//		//进行授权角色
//        //TODO:给teacher装配角色
////		authorizationInfo.setRoles(teacherService.getRoles(userName));
//		//进行授权权限
//        //TODO:给teacher装配权限
////		authorizationInfo.setStringPermissions(teacherService.getPermissions(userName));
//		return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //TODO:对教师身份进行验证
        return null;
//        String userName=(String)token.getPrincipal();
//        String passWord = new String((char[])token.getCredentials());
//        //TODO:根据账号和密码查询
//        SysEmployee teacher = new SysEmployee();
//        //根据用户名查找用户信息
//        if(teacher == null) {
//            throw new AuthenticationException();
//        }
//        AuthenticationInfo authcInfo=new SimpleAuthenticationInfo(userName, passWord, getName());
//        return authcInfo;
    }
}
