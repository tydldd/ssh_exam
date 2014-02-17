/**
 * 文件名：ExtendsTest.java
 *
 * 版本信息：1.0
 * 日期：2013-6-26
 * Copyright ru Corporation 2013 版权所有
 *
 */
package com.ru.javaExam.processcontrol;

import org.junit.Test;

import oracle.net.ano.SupervisorService;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：
 * 创建人：nanchengru
 * 创建时间：2013-6-26 下午04:22:34
 * 修改人：nanchengru
 * 修改时间：2013-6-26 下午04:22:34
 * 修改备注：
 * 环境：  jdk1.7
 */


public class ExtendsTest extends Dog{
	
	public ExtendsTest(){
		super();
	}
	public void s(){
		System.out.println(super.getName());
		System.out.println("123");
	}
	
	@Test
	public void test(){
		s();
	}

}
