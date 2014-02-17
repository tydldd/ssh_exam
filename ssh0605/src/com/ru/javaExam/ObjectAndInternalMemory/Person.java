/**
 * 文件名：Person.java
 *
 * 版本信息：
 * 日期：2013-6-19
 * Copyright 足下 Corporation 2013 
 * 版权所有
 *
 */
package com.ru.javaExam.ObjectAndInternalMemory;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：
 * 创建人：nanchengru
 * 创建时间：2013-6-19 下午02:08:41
 * 修改人：nanchengru
 * 修改时间：2013-6-19 下午02:08:41
 * 修改备注：
 * 环境：  jdk1.7
 * 版本：    1.0
 */
public class Person {
	String name;
	int age;
	static double weight;//静态变量（类变量）
	
	/**
	 * 
	 * 展示个人信息
	 */
	public void info(){
		System.out.println("姓名：" + name + "  ，年龄：" + age);
	}
}
