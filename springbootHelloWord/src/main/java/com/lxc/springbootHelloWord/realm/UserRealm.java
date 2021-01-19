package com.lxc.springbootHelloWord.realm;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.lxc.springbootHelloWord.mapper.PermissionMapper;
import com.lxc.springbootHelloWord.model.Role;
import com.lxc.springbootHelloWord.model.User;
import com.lxc.springbootHelloWord.service.PermissionService;
import com.lxc.springbootHelloWord.service.RoleService;
import com.lxc.springbootHelloWord.service.UserService;


public class UserRealm extends AuthorizingRealm {
	
	@Autowired
    private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private PermissionService permissionService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
		// 这里做角色权限控制
		String username = (String)pc.getPrimaryPrincipal();
		User user = userService.selectUserByUsername(username);
		Integer roleid = user.getRoleid();
		//角色
		Role role = roleService.getRole(roleid);
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addRole(role.getRolename());
	    List<String> perList = permissionService.getPerList(roleid);
	    info.addStringPermissions(perList);
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken at) throws AuthenticationException {
		// 这里做登录控制
		// 获取登录名称
		AuthenticationInfo info;
		String username = (String)at.getPrincipal();
		User user = userService.selectUserByUsername(username);
		if(user != null) {
			 info = new SimpleAuthenticationInfo(username, "", "刘仙臣");
			 return info;
		}
		return null;
	}

}
