/**
 * 文件名：DataTypeAutoPromote.java
 *
 * 版本信息：1.0
 * 日期：2013-6-24
 * Copyright ru Corporation 2013 版权所有
 *
 */
package com.ru.javaExam.expression;

import org.junit.Test;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：表达式类型的自动提升
 * 创建人：nanchengru
 * 创建时间：2013-6-24 下午04:43:47
 * 修改人：nanchengru
 * 修改时间：2013-6-24 下午04:43:47
 * 修改备注：
 * 环境：  jdk1.7
 */
public class DataTypeAutoPromote {
	
	/**
	 * 
	 * dataType1
	 * (java语言规定：当一个算数表达式中包含多个基本类型的值时，整个算术表达式的数据类型将发生自动提升。
	 * 规则如下：1、所有byte型、short型、和char型将被提升到int型。
	 * 2、整个算术表达式的数据类型自动提升到与表达式中最高等级操作数同样的类型
	 * 数据类型等级：
	 * 		   char - 
	 * 					int - long - float - double								
	 * byte - short -             
	 * )
	 * @param  
	 * @return 
	 * @throws
	 */
	@Test
	public void dataType1(){
		//1定义一个short类型变量
		short svalue = 5;
		//svalue = svalue -2;//1.因为2是int型，所以表达式执行后转成int型，而svaleu是short型变量，报错。
		
		//2result右面表达式最高等级的数据类型是double
		byte b = 40;
		char c = 'a';
		int i = 23;
		double d = 1.23;
		double result = b + c + i * d;
		System.out.println("result = " + result);
		
		//3只有int值表达式，结果还是int
		int val = 3;
		int intresult = 23/val;
		System.out.println("intresult = " + intresult);
		
		//4当基本类型和String类型进行连接运算时，系统将基本类型的值自动转换成String类型
		String s = "Hello java ";
		//系统自动将‘a’和7转换成字符串
		String s1 = s + c + val;
		//系统自动将‘a’转换成int，然后将int转换成String
		String s2 = c + val + s;
		System.out.println(s1);
		System.out.println(s2);
	}
	
	
}
