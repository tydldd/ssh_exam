/**
 * 文件名：OverridTest.java
 *
 * 版本信息：1.0
 * 日期：2013-6-28
 * Copyright ru Corporation 2013 版权所有
 *
 */
package com.ru.javaExam.processcontrol;

import org.junit.Test;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：方法重载
 * 创建人：nanchengru
 * 创建时间：2013-6-28 上午09:31:38
 * 修改人：nanchengru
 * 修改时间：2013-6-28 上午09:31:38
 * 修改备注：
 * 环境：  jdk1.7
 */
public class OverridTest {
	
	static int i = 0;
	
	@Test
	public void test(){
		for(int a = 0; a < 10; a++){
			i++;
		}
		System.out.println(i);
	}
	
	
}
