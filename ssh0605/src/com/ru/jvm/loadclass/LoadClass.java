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
		cl.loadClass("com.ru.jvm.loadclass.Tester");
		System.out.println("装载类");
		//初始化类
		Class.forName("com.ru.jvm.loadclass.Tester");
//		Tester test =new Tester();
//		test.test();
	}
}
