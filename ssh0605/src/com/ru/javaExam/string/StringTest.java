/**
 * 文件名：StringTest.java
 *
 * 版本信息：1.0
 * 日期：2013-7-1
 * Copyright ru Corporation 2013 版权所有
 *
 */
package com.ru.javaExam.string;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：String类
 * 创建人：nanchengru
 * 创建时间：2013-7-1 下午02:38:05
 * 修改人：nanchengru
 * 修改时间：2013-7-1 下午02:38:05
 * 修改备注：
 * 环境：  jdk1.7
 */
public class StringTest {
	
	public String toUpperCase(String s){
		return s.toUpperCase();
	}
	
	/**
	 * 
	 * test1(String类具有不可变性)
	 * @param  
	 * @return 
	 * @throws
	 */
	//@Test
	public void test1(){
		String s = "hello";
		String ss = toUpperCase(s);
		System.out.println("s = " + s + "   ss = " + ss);
	}
	
	/**
	 * 
	 * test2(无意识的递归)
	 * @param  
	 * @return 
	 * @throws
	 */
	@Test
	public void test2(){
		
		List<Coffee> list = new ArrayList<Coffee>();
		
		for(int i = 0; i < 10; i++){
			list.add(new Coffee());
		}
		System.out.println(list);
		
		Object o = new Object();
	}
	
}
