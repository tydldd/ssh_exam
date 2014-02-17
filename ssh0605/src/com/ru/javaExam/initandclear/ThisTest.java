/**
 * 文件名：ThisTest.java
 *
 * 版本信息：1.0
 * 日期：2013-6-28
 * Copyright ru Corporation 2013 版权所有
 *
 */
package com.ru.javaExam.initandclear;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：
 * 创建人：nanchengru
 * 创建时间：2013-6-28 上午09:57:45
 * 修改人：nanchengru
 * 修改时间：2013-6-28 上午09:57:45
 * 修改备注：
 * 环境：  jdk1.7
 */
public class ThisTest {
	
	int i = 0;
	ThisTest tt(){
		i++;
		return this;
	}
	
	void print(){
		System.out.println("i = " + i);
	}
	
	public void intTest(){
		int i = 0;
		i++;
	}
	
	public static void main(String[] args){
		ThisTest tt = new ThisTest();
		tt.tt().tt().tt().print();
		int a = 0;
		for(int i = 0; i < 10; i++)
			a++;
		
	}
	
}
