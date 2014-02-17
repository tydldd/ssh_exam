/**
 * 文件名：IfElseTest.java
 *
 * 版本信息：1.0
 * 日期：2013-6-27
 * Copyright ru Corporation 2013 版权所有
 *
 */
package com.ru.javaExam.processcontrol;

import org.junit.Test;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：if else实例
 * 创建人：nanchengru
 * 创建时间：2013-6-27 下午04:27:51
 * 修改人：nanchengru
 * 修改时间：2013-6-27 下午04:27:51
 * 修改备注：
 * 环境：  jdk1.7
 */
public class IfElseTest {
	
	static int result = 1;
	public void test(int val, int target){
		if(val < target){
			result = +1;
			System.out.println("run");
		}else if(val > target){
			result = -1;
		}else{
			result = 0;
		}
	}
	
	@Test
	public void test(){
		//test(5, 10);
		test(5, 5);
		System.out.println(result);
		return;
	}
}
