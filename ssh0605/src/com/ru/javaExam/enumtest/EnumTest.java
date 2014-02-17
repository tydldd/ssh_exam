/**
 * fileNmae：EnumTest.java
 *
 * version：1.0
 * date：2013-7-2
 * Copyright ru Corporation 2013 版权所有
 *
 */
package com.ru.javaExam.enumtest;

import org.junit.Test;

/**
 * 
 * project name：ssh0605
 * class description：实现接口的枚举类
 * author：nanchengru
 * create date：2013-7-2 下午02:58:52
 * uploader：nanchengru
 * upload date：2013-7-2 下午02:58:52
 * upload remark：
 * environment：jdk1.7
 */
public enum EnumTest implements FruitInter{
	
	//让每个属性实现接口方法，大括号里面的代码相当于匿名内部类
	APPLE("apple"){
		public void info(){
			System.out.println("这是苹果");
		}
	},
	
	PEAR("pear"){
		public void info(){
			System.out.println("这是梨");
		}
	};
	
	String account;
	
	private EnumTest(String s){
		this.account = s;
	} 
	
	public String getAccount(){
		return account;
	}
	
	public static void main(String[] args){
		for(EnumTest e : EnumTest.values()){
			e.info();
			System.out.println(e.getAccount());
		}
	}
	
}

interface FruitInter{
	public void info();
}

