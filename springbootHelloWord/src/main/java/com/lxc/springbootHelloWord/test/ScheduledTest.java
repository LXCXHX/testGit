package com.lxc.springbootHelloWord.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTest {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Scheduled(fixedRate = 2000)
	public void scheduled() {
		System.out.println("码家学院提示你==》现在时间：" + dateFormat.format(new Date()));
	}
	
  

}
