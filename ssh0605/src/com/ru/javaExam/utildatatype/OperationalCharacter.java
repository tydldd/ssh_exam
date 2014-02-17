/**
 * 版本信息：Copyright ru Corporation 2013 
 * 版权所有
 *
 */
package com.ru.javaExam.utildatatype;

import org.junit.Test;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：运算符
 * 创建人：成如
 * 创建时间：2013-8-26 下午4:12:21
 * 修改人：成如
 * 修改时间：2013-8-26 下午4:12:21
 * 修改备注：
 * @since jdk1.7
 * @version 1.0
 */
public class OperationalCharacter {

	@Test
	public void test(){
		//addCharacter();
		//reduceCharacter();
		multiplyCharacter();
		divideCharacter();
		character();
		identitycharacter();
		decrementCharacter();
	}
	
	//+运算符
	public void addCharacter(){
		double d1 = 2.13;
		short s = 23;
		String s1 = "nan";
		String s2 = "chengru";
		
		double d2 = d1 + s;
		String ss = s1 + s2;
		
		System.out.println("double + short = " + d2 + " 两个字符串想加得到一个字符串：" + ss);
	}
	
	//减运算符
	public void reduceCharacter(){
		String ss = null;
		double d = 123.56;
		long lon = 23L;
		String s1 = "nan";
		String s2 = "chengru";
		
		//ss = s1 - s2;  两个字符串不能执行-操作
		double dd = d - lon;
		
		System.out.println(" double - long = " + dd);
	}
	
	//乘运算符
	public void multiplyCharacter(){
		long ll;
		long l = 12L;
		byte b = 12;
		String s1 = "nan";
		String s2 = "chengru";
		
		ll = l * b;
		//String ss = s1 * s2;  字符串不能相乘
		
		System.out.println("long * byte  = " + ll);
	}
	
	//除运算符
	public void divideCharacter(){
		long ll;
		long l = 12L;
		byte b = 11;
		int i = 0;
		float f = 0.0F;
		
		String s1 = "nan";
		String s2 = "chengru";
		
		ll = l / b;
		//long ll2 = l / i;  分子为0，出现空指针异常
		float ll3 = l / f;  //但是分子可以是浮点型
		//String ss = s1 * s2;  字符串不能相乘
		System.out.println("正无穷大：" + ll3);
		System.out.println("long / byte  = " + ll);
	}
		
	//求余运算符
	public void character(){
		long ll;
		int i = 29;
		byte b = 9;
		
		ll = i % b;
		
		System.out.println("int % byte  = " + ll + "   向上转型成long型");
	}
	
	//自增运算符
	public void identitycharacter(){
		int a = 5;
		int aa = 5;
		
		int b = a++ + 6;
		int c = ++aa + 6;
		
		System.out.println("b  = " + b + "   c = " + c);
	}	
	
	//自减运算符
	public void decrementCharacter(){
		int a = 5;
		int aa = 5;
		
		int b = a-- + 5;
		int c = --aa + 5;
		
		System.out.println("b  = " + b + "   c = " + c);
	}	
}
