/**
 * fileNmae：SweetShop.java
 *
 * version：1.0
 * date：2013-7-2
 * Copyright ru Corporation 2013 版权所有
 *
 */
package com.ru.javaExam.classtype;

import org.junit.Test;

/**
 * 
 * project name：ssh0605
 * class description：
 * author：nanchengru
 * create date：2013-7-2 上午09:58:09
 * uploader：nanchengru
 * upload date：2013-7-2 上午09:58:09
 * upload remark：
 * environment：jdk1.7
 */
class Candy{
	static{
		System.out.println("loading candy   static 代码块");
	}
	{
		System.out.println("非静态代码块");
	}
}

class Gum{
	static{
		System.out.println("loading Gum");
	}
}

public class SweetShop {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args){
		
		new Candy();
		
		//Class.forName("Gum")可以实例化对象，并返回类的引用
		try {
			@SuppressWarnings("unused")
			Class gum = Class.forName("Gum");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//只返回类引用，不会初始化对象
		Class clazz = Gum.class;
		
		System.out.println("end");
	}
}
