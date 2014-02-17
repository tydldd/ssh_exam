/**
 * 文件名：Sub.java
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
 * 类描述：内存中子类实例
 * 创建人：nanchengru
 * 创建时间：2013-6-19 下午05:48:59
 * 修改人：nanchengru
 * 修改时间：2013-6-19 下午05:48:59
 * 修改备注：
 * 环境：  jdk1.7
 * 版本：    1.0
 */
class Base2{
	int count = 2;
}

class Mid extends Base2{
	int count = 20;
}
public class Sub extends Mid{
	int count = 200;
	public static void main(String[] args){
		Sub s = new Sub();
		Mid m = s;
		Base2 b = s;
		
		//通过3个变量来访问count变量
		System.out.println("s.count = " + s.count);
		System.out.println("m.count = " + m.count);
		System.out.println("b.count = " + b.count);
	} 
}
