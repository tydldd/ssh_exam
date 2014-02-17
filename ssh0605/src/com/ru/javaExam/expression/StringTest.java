/**
 * 文件名：StringTest.java
 *
 * 版本信息：
 * 日期：2013-6-24
 * Copyright 足下 Corporation 2013 
 * 版权所有
 *
 */
package com.ru.javaExam.expression;

import org.junit.Test;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：字符串的陷阱
 * 创建人：nanchengru
 * 创建时间：2013-6-24 下午02:04:50
 * 修改人：nanchengru
 * 修改时间：2013-6-24 下午02:04:50
 * 修改备注：
 * 环境：  jdk1.7
 * 版本：    1.0
 */
public class StringTest {
	
	/**
	 * 
	 * stringTest1
	 * (1、java程序中的字符直接量，JVM会使用一个字符串池来保存他们：当第一次使用一个字符串直接量时，JVM会把它放入
	 * 字符串池进行缓存。一般情况下，字符串池中的对象不会被垃圾回收。最次使用时无需创建新的字符串，直接指向字符
	 * 串池中已有的字符串。
	 * 2、定义不可变字符串使用String,定义可变字符串使用StringBuilder.(Stringbuffer是线程安全的，StringBuilder是线程不安全的，
	 * 为了运行速度一般使用StringBuilder)
	 * 3、比较两个字符串是否相同，用==进行判断。比较两个字符串缩包含的字符序列是否相等，使用equals())
	 * @param  
	 * @return 
	 * @throws
	 */
	@Test
	public void stringTest1(){
		//将 str1  "Hello java"放入字符串池
		String str1 = "Hello java";
		//指向字符串缓冲池中的 "Hello java"
		String str2 = "Hello java";
		System.out.println("stringTest1 ：");
		System.out.println(str1 == str2);
	}
	
	@Test
	public void stringTest2(){
		String str1 = "Hello java 的长度是：10";
		//字符串拼接，编译时依然指向缓冲池
		String str2 = "Hello " + "java" + " 的长度是：" + 10;
		System.out.println("stringTest2 :" + "str2 = " + str2);
		System.out.println(str1 == str2);
	}
	
	/**
	 * 
	 * stringTest3(如果字符串中使用了变量，或调用了方法，那就只能等运行时才能确定该字符窜的值,无法利用字符串池)
	 * @param  
	 * @return 
	 * @throws
	 */
	@Test
	public void stringTest3(){
		String str1 = "Hello java 的长度是：10";
		//字符串中使用了方法，不能在编译是指向缓冲池
		String str2 = "Hello " + "java" + " 的长度是：" + "Hello java".length();
		System.out.println("stringTest3 :");
		System.out.println(str1 == str2);
		
		int len = 10;
		//同样str3中，使用了len变量
		String str3 = "Hello " + "java" + " 的长度是：" + len;
		System.out.println(str1 == str3);
	}
	
	/**
	 * 
	 * StringTest4(使用String 会造成内存泄漏)
	 * @param  
	 * @return 
	 * @throws
	 */
	@Test
	public void StringTest4(){
		System.out.println("stringTest4哈希值：");
		//字符串放入缓冲池，不会被垃圾回收
		String str = "Hello ";
		System.out.println(System.identityHashCode(str));
		//"Hello java"被放入缓冲池，str指向这个对象，不会回收"Hello "对象
		str = str + "java";
		System.out.println(System.identityHashCode(str));
	}
	
	/**
	 * 
	 * stringBuilderTest(StringBuilder在拼接字符串时，字符串指向同意内存空间，可以解决内存泄漏问题)
	 * @param  
	 * @return 
	 * @throws
	 */
	@Test
	public void stringBuilderTest(){
		System.out.println("stringBuilderTest 哈希值：");
		StringBuilder s = new StringBuilder();
		s = s.append("Hello ");
		System.out.println("s = "+ s + "  hashcode:" +System.identityHashCode(s));
		s = s.append("java");
		System.out.println("s = "+ s + "  hashcode:" +System.identityHashCode(s));
	}
}
