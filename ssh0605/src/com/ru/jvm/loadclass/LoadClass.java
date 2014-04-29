package com.ru.jvm.loadclass;

/**
 * 验证类加载
 * @author nange
 *
 */
public class LoadClass {

	public static void main(String[] args) throws ClassNotFoundException {
		ClassLoader cl = ClassLoader.getSystemClassLoader();
		//装载类
		cl.loadClass("com.ru.jvm.loadclass.Tester1");
		System.out.println("装载类");
		//初始化类
		Class.forName("com.ru.jvm.loadclass.Tester1");
//		Tester test =new Tester();
//		test.test();
	}
}

class Tester1 {

	static{
		System.out.println("初始化类");
	}
	static String a = "111";
	
	Tester1(){
		System.out.println("构造");
	}
	
	public static void main(String[] args) {
		System.out.println("main");
	}
	
	public void test(){
		System.out.println("test 方法");
	}
}
