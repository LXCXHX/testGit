package com.lxc.springbootHelloWord.action;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginAction {

	@PostMapping("/tologin")
	public ModelAndView login(String username, String passwd) {
		if ("lxc".equals(username) && "123".equals(passwd)) {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("redirect:/main");
			return mv;
		} else {
			return null;
		}
	}

	@RequestMapping("/main")
	public String mainUI(Model model) {
		model.addAttribute("name", "刘仙臣");
		return "main";
	}

}
