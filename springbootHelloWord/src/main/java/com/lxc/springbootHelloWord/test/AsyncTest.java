package com.lxc.springbootHelloWord.test;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncTest {
    
	@Async
	public void asyncOut(){
		System.out.println("异步线程的名称:"+Thread.currentThread().getName());
	}
}
