/**
 * 文件名：ForTest.java
 *
 * 版本信息：1.0
 * 日期：2013-6-25
 * Copyright ru Corporation 2013 版权所有
 *
 */
package com.ru.javaExam.processcontrol;

import org.junit.Test;

import com.ru.javaExam.expression.StringTest;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：
 * 创建人：nanchengru
 * 创建时间：2013-6-25 下午01:57:37
 * 修改人：nanchengru
 * 修改时间：2013-6-25 下午01:57:37
 * 修改备注：
 * 环境：  jdk1.7
 */
class Cat{
	
	private static int count = 0;
	private int count2 = 0;
	public Cat(){
		System.out.println("调用cat的无参构造器");
		count++;
		count2++;
	}
	
	/**
	 * 
	 * getCount(静态变量一旦初始化（第一次调用），就会分配内存空间，以后一直使用同一块内存。知道tomcat关闭。
 		静态方法同上)
	 * @param  
	 * @return 
	 * @throws
	 */
	public static int getCount(){
		return count;
	}
	public int getCount2(){
		return count2;
	}
}

public class ForTest extends StringTest{
	
	/* (non-Javadoc)
	 * @see com.ru.javaExam.expression.StringTest#stringTest1()
	 */
	@Override
	public void stringTest1() {
		super.stringTest1();
	}
	@Test
	public void catTest(){
		for(int i = 0; i < 10; i++){
			Cat cat = new Cat();
			System.out.println(cat.getCount());
			System.out.println(cat.getCount2());
		}
		//System.out.println(Cat.getCount());
	}
}
