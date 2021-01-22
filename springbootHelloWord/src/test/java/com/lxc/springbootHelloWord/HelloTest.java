package com.lxc.springbootHelloWord;

import java.util.Locale;
import java.util.ResourceBundle;

public class HelloTest {
    public static void main(String[] args) {
    	/*Locale[] ls = Locale.getAvailableLocales();
    	for(Locale l : ls){
    		System.out.println(l.getDisplayCountry());    //得到国家名字  中国 美国
    		System.out.println(l.getCountry());				//得到国家码  CN US
    		System.out.println(l.getDisplayLanguage());		//中文 英文
    		System.out.println(l.getLanguage());  			//zh en
    	}*/
    	
    	Locale ls1 = Locale.getDefault();  
    	Locale ls2 = Locale.US;
    	ResourceBundle bundle = ResourceBundle.getBundle("ApplicationResources",ls1);//这里的hello就是前面创建的文件
    	String value = bundle.getString("homePageTitle");
        System.out.println(value);

	}
}
