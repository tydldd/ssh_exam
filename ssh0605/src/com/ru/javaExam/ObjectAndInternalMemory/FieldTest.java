/**
 * 文件名：FieldTest.java
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
 * 类描述：静态变量（类变量）测试
 * 创建人：nanchengru
 * 创建时间：2013-6-19 下午02:13:52
 * 修改人：nanchengru
 * 修改时间：2013-6-19 下午02:13:52
 * 修改备注：
 * 环境：  jdk1.7
 * 版本：    1.0
 */
public class FieldTest {
	
	public static void main(String[] args){
		
		//初始化Person对象，给静态变量赋值，weight变量初始化也完成，此时堆内存给weight分配内存空间。
		//以后对weight的操作都是针对这块内存，不会重新分配内存。
		Person.weight = 150;
		System.out.println("person.weight = " + Person.weight);
		
		//创建第一个Person对象(分配一块内存空间，保存name和age属性)
		Person p1 = new Person();
		p1.name = "nancengru";
		p1.age = 24;
		//通过person对象p1访问weight，底层依然是使用Person.weight访问类变量
		System.out.println("weight = " + p1.weight);
		p1.info();
		
		//创建第二个Person对象(分配另一块内存)
		Person p2 = new Person();
		p2.name = "ruye";
		p2.age = 24;
		p2.info();
	}
}
