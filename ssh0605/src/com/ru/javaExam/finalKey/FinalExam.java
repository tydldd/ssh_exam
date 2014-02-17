/**
 * 文件名：FinalExam.java
 *
 * 版本信息：
 * 日期：2013-6-20
 * Copyright 足下 Corporation 2013 
 * 版权所有
 *
 */
package com.ru.javaExam.finalKey;

import org.junit.Test;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：final关键字
 * 创建人：nanchengru
 * 创建时间：2013-6-20 下午04:10:28
 * 修改人：nanchengru
 * 修改时间：2013-6-20 下午04:10:28
 * 修改备注：
 * 环境：  jdk1.7
 * 版本：    1.0
 */
public class FinalExam {
	
	final private String s = "this is a final virable";
	final String s2;
	{
		s2 = "the second";
	}
	
	/**
	 * 
	 * final关键字：1、被finally修饰的变量被赋初始值后，不能对它重新赋值
	 * 2、被final修饰的方法不能被重写
	 * 3、被final修饰的类不能呗继承
	
	 * @param  
	
	 * @return 
	
	 * @throws
	 */
	@Test
	public void test(){
		System.out.println(s);
	}
}
