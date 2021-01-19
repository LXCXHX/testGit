package com.lxc.springbootHelloWord.action;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lxc.springbootHelloWord.model.User;
import com.lxc.springbootHelloWord.service.UserService;
import com.lxc.springbootHelloWord.test.AsyncTest;

@RestController
@RequestMapping("user")
public class UserAction {
   
	@Autowired
	private UserService userService;
	
	@Autowired
	private AsyncTest asyncTest;
	
	@RequiresRoles("admin")
	@RequestMapping("/getUser")
	public Object getUser(Integer id) {
	    User user = userService.getUser(id);
	    return user;
	}
	
	
    @RequestMapping("/updateUser")
	public String updateUser(User user){
    	userService.updateUser(user);
	    return "success";
	}
    
    @RequiresPermissions("sys:delete")
    @RequestMapping("/deleteUser")
	public String deleteUser(Integer id) {
    	userService.deleteUser(id);
		return "success";
	}
    
    @RequestMapping("/insertUser")
    public String insertUser(User user){
    	userService.insertUser(user);
    	return "success";
    }
    
    @RequestMapping("/login")
    public String login(){
    	System.out.println("主线程的名称："+Thread.currentThread().getName());
    	asyncTest.asyncOut();
    	return "login";
    }
    
    /**
     * 简单登录，无需密码
     * @param username
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin(String username){
    	Subject subject = SecurityUtils.getSubject();
    	AuthenticationToken at = new UsernamePasswordToken(username, "");
		try {
			subject.login(at);
		} catch (Exception e) {
			//抛出异常则登录失败
			return "loginFailed";
		}
    	return "loginSuccess";
    }
}
