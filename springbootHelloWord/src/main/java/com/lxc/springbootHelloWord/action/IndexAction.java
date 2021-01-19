package com.lxc.springbootHelloWord.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexAction {
	 @RequestMapping("/loginUI")
     public String index(){
    	 return "login";
     }
}
