package com.lxc.springbootHelloWord.action;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloAction {
	

    @RequestMapping("/hello")
	public String hello() {
		return "Hello spring boot";
	}
    
    @RequestMapping("/excep")
    public String excep() {
    	int a = 1/0;
        return "异常了";
    }
    
    
    
    
    /*@GetMapping("/getUser")
	public Object getUser(Integer id) {
		User user = userMapper.getUeser(id);
		return user;
	}
	
	@PostMapping("/insertUser")
	public String insertUser(String name,String sex) {
		userMapper.insertUser(name,sex);
		return "success";
	}
	
	@RequestMapping("/tranc")
    public String tranc(String name,Integer id) {
		userService.tranc(name, id);
		return "success";
    }*/
	
}
