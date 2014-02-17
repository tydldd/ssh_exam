/**
 * 文件名：DataTypeTranslate.java
 *
 * 版本信息：1.0
 * 日期：2013-6-27
 * Copyright ru Corporation 2013 版权所有
 *
 */
package com.ru.javaExam.operator;

import org.junit.Test;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：数据类型转换
 * 创建人：nanchengru
 * 创建时间：2013-6-27 下午03:41:27
 * 修改人：nanchengru
 * 修改时间：2013-6-27 下午03:41:27
 * 修改备注：
 * 环境：  jdk1.7
 */
public class DataTypeTranslate {
	/**
	 * 
	 * test(向上类型转换可以不显示进行，向下类型转化必须显示进行
	 * 2.显示类型转换：int i2 = (int) d;隐式类型转换：double d2 = i;（i为int型）)
	 * @param  
	 * @return 
	 * @throws
	 */
	@Test
	public void test(){
		char c = 'w';
		int i = 1;
		double d = 3.9;
		float f = 1f;
		//显示类型转换
		int i2 = (int) d;
		Double dd = new Double(d);
		int i3 = dd.intValue();
		//隐式类型转换
		double d2 = i;
		long l = c;
		System.out.println(i2 + "    " + i3);
	}
}
