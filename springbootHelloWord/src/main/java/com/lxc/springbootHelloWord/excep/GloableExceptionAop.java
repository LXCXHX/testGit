package com.lxc.springbootHelloWord.excep;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GloableExceptionAop {
    
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public Map<String,Object> getException() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("errorCode", "404");
		map.put("errorMsg", "找不到页面了!");
		return map;
        //return "全局捕获异常!";		
	}
}
