package com.ru.jvm.loadclass;

public class Tester {

	static{
		System.out.println("初始化类");
	}
	static String a = "111";
	
	Tester(){
		System.out.println("构造");
	}
	
	public static void main(String[] args) {
		System.out.println("main");
	}
	
	public void test(){
		System.out.println("test 方法");
	}
}
