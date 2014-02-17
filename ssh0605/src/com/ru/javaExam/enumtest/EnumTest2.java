/**
 * 版本信息：Copyright ru Corporation 2013 
 * 版权所有
 *
 */
package com.ru.javaExam.enumtest;

import org.junit.Test;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：
 * 创建人：成如
 * 创建时间：2013-9-9 上午11:53:33
 * 修改人：成如
 * 修改时间：2013-9-9 上午11:53:33
 * 修改备注：
 * @since jdk1.7
 * @version 1.0
 */
public enum EnumTest2 {

	//枚举类中列出枚举值时，实际就是调用构造器创建枚举对象。
	//例如：EAST("east")相当于public static final EnumTest2 EAST = new EnumTest2("east");
	EAST("east"),
	WEST("west"),
	SOUTH("south"),
	North("north");
	
	private String names;
	
	//枚举类的构造器只能使用private修饰符
	private EnumTest2(String name){
		this.names = name;
	}
	
	public String getName(){
		return names;
	}
	
	public static void main(String[] args){
		for(EnumTest2 e : EnumTest2.values()){
			System.out.println(e.getName());
		}
		
		System.out.println("变量：" + EnumTest2.EAST.getName());
		System.out.println("变量：" + EnumTest2.EAST.toString());
	}
}

enum Test2{
	//列出的枚举类属性，例如：EAST相当于public static final Test2 EAST = new Test2();
	//使用默认的无参构造函数
	EAST,WEST,SOUTH;
}