/**
 * 文件名：ListTest.java
 *
 * 版本信息：
 * 日期：2013-6-21
 * Copyright 足下 Corporation 2013 
 * 版权所有
 *
 */
package com.ru.javaExam.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：验证java集合，只是多个变量引用的集合
 * 创建人：nanchengru
 * 创建时间：2013-6-21 下午01:51:06
 * 修改人：nanchengru
 * 修改时间：2013-6-21 下午01:51:06
 * 修改备注：
 * 环境：  jdk1.7
 * 版本：   1.0
 */
class Apple{
	double weight;

	public Apple(double weight) {
		super();
		this.weight = weight;
	}
}


public class ListTest {
	public static void main(String[] args){
		//创建两个apple对象
		Apple a1 = new Apple(2.2);
		Apple a2 = new Apple(1.9);
		//将两个Apple放入list列表
		List<Apple> appleList = new ArrayList<Apple>(4);
		appleList.add(a1);
		appleList.add(a2);
		//判断集合list引用的变量是否和原来引用的变量相同
		System.out.println(appleList.get(0) == a1);
	}
	
	
}
