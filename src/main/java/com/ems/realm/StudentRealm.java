package com.ems.realm;

import com.ems.entity.Student;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;


public class StudentRealm extends AuthorizingRealm {

//	@Autowired
//	StudentService studentService;

	/**
	 * 为当前登录的用户授予角色和权限
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//TODO:授予学生权限
		return null;
//		//获取用户名
//		String userName=(String)principals.getPrimaryPrincipal();
//		SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
//		//进行授权角色
//		authorizationInfo.setRoles(userService.getRoles(userName));
//		//进行授权权限
//		authorizationInfo.setStringPermissions(userService.getPermissions(userName));
//		return authorizationInfo;
	}

	/**
	 *验证当前登录的用户
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//TODO:用于学生登录
		return null;
//		String userName=(String)token.getPrincipal();
//		//根据用户名查找用户信息
//		User user=userService.getByUserName(userName);
//		if(user!=null){
//			AuthenticationInfo authcInfo=new SimpleAuthenticationInfo(user.getUserName(),user.getPassword(),getName());
//			return authcInfo;
//		}else{
//			return null;
//		}
	}
}
