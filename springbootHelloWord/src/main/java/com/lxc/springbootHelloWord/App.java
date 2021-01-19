package com.lxc.springbootHelloWord;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Hello world!
 *
 */
@SpringBootApplication
/*@EnableScheduling*/
@EnableAsync
public class App 
{
    public static void main( String[] args )
    {   
    	//从main方法启动spring 应用的类
        SpringApplication.run(App.class, args);
    }
}
