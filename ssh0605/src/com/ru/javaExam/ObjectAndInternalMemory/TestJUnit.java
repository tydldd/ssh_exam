/**
 * 文件名：Test.java
 *
 * 版本信息：
 * 日期：2013-6-19
 * Copyright 足下 Corporation 2013 
 * 版权所有
 *
 */
package com.ru.javaExam.ObjectAndInternalMemory;
import org.junit.*;
/**
 * 
 * 项目名称：ssh0605
 * 类描述：
 * 创建人：nanchengru
 * 创建时间：2013-6-19 下午02:33:45
 * 修改人：nanchengru
 * 修改时间：2013-6-19 下午02:33:45
 * 修改备注：
 * 环境：  jdk1.7
 * 版本：    1.0
 */
public class TestJUnit {
	
	@Test
	public void test1(){
		System.out.println("Person.weight = " + Person.weight);	
	}
}
