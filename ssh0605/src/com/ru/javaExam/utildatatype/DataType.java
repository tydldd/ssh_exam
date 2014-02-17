package com.ru.javaExam.utildatatype;

import java.util.List;

import org.junit.Test;

/**
 * 
 * 
 * 项目名称：ssh0605
 * 类描述：数据类型
 * 创建人：成如
 * 创建时间：2013-8-15 下午5:45:46
 * 修改人：成如
 * 修改时间：2013-8-15 下午5:45:46
 * 修改备注：
 * @since jdk1.7
 * @version 1.0
 */
@SuppressWarnings("unused")
public class DataType {

	/**
	 * 
	 * (两种浮点类型（float和double）,如果不加F后缀和D后缀，默认是double类型的)
	 * 将如
	 * @param  
	 * @return 
	 * @throws
	 */
	
	public void testFolat(){
		float f2 = 12;
		float f = 12.0789F;//有小数的数字默认当成double处理，只有显示加上F才会被当作float处理
		double d = 12.0;//默认是double型
		double d2 = 12;
		double d3 = 12.234;
		char a = 'a';
		byte b = 123;//对于123小于byte的表示范围，默认把123当作byte处理
		long l = 123456789111111111L;//如果只是1234567891111111111，这默认当成int行处理，如果想让java当成long处理需要加L
		//System.out.println(1.2/0);
		
		//自动类型转换
		byte b123 = 123;
		char c123 = 'o';
		short s123 = b123;//byte自动转换成shoort
		int i123 = b123;//short自动转换成int型
		i123 = c123;//字符型自动转换成int型
		long l123 = i123;//int自动转换成long
		float f123 = l123;//long自动转换成float
		double d123 = f123;//float自动转换成duble
		
		//强制类型转换(将高等级数据类型转换成低等级数据类型，可能会丧失数据准确性)
		double d234 = 123.4567;
		int i234 = (int) d234;
		//System.out.println("i234 = " + i234);
		
		//表达式的自动类型转换
		short s345 = 123;
		int i345 = s345 + 5;//short类型自动转换成int类型
		//System.out.println("i345 = " + i345);
	
		//比较运算符
		short s = 123;
		int i = 123;
		String ss = "qwe";
		String sss = new String("qwe");
		System.out.println(ss.equals(sss));
		
		System.out.println(1^2);
	}
	
	public void assignment(){
		
		//赋值运算符
		//1.常量赋值
		String s1 = "nan";
		String s2 = "rushen";
		double bb = 2.34;
		boolean bool = true;
		
		//2.将一个变量的值赋给另一个变量
		s1 = s2;
		
		//3、赋值运算符支持连续赋值，使用多个赋值运算符可以为多个变量赋值。
		int a;
		int b;
		int c;
		
		a = b = c = 7;
		
		System.out.println("a = " + a + "  b = " + b + " c = " + c);
	}
	
	/**
	 * 
	 * (比较运算符)
	 * @param  
	 * @return 
	 * @throws
	 */
	public void compare(){
		
		short sh = 123;
		int in = 123;
		//两个数值类型，只要值相等就为true
		System.out.println("sh == in = " + (sh == in));
		System.out.println("sh != in  = " + (sh != in));
		
		//引用对象(指向同一实例对象才返回true)
		String str = "abc";
		String str2 = new String("abc");
		System.out.println("str == str2 = " + (str == str2));
		System.out.println("str != str2  = " + (str != str2));
	}
	
	/**
	 * 
	 * (逻辑运算符)
	 * @param  
	 * @return 
	 * @throws
	 */
	public void logic(){
		//&& 和 &的异同：&&可以称为逻辑与，&称为位与。
		//相同点：都可以用作与运算，
		//不同点：（1）&&具有短路功能(及如果第一个表达式为false，则直接返回false,不执行第二个表达式),
		//（2）& 会执行全部 表达式。所以&&在第二个表达式为null时，可能不抛出异常。&一定会抛出空指针异常。
		//并且当&操作符两边的表达式不是boolean类型时，&表示按位与操作。
		boolean b1 = false;
		boolean b2 = true;
		List<String> list = null;
		
		boolean bb1 = true;
		boolean bb2 = true;
		
		
		//第一个表达式为false，不执行第二个表达式，不跑出异常。
		if(b1 == b2 && list.size() != 0){
			System.out.println("这句不能执行，如果执行抛出空指针异常");
		}else{
			System.out.println("逻辑与，当第一个表达式为false时，不再执行第二个表达式，不抛出空指针异常。");
		}
		
		System.out.println("bb1 ^ bb2  = " + (bb1^bb2));
		
		//仍然执行第二个表达式，抛出异常
		try {
			if(b1 == b2 & list.size() != 0){
				System.out.println("位与，当第一个表达式为false时，仍然执行第二个表达式，抛出空指针异常。");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 
	 * (三目表达式)
	 * @param  
	 * @return 
	 * @throws
	 */
	
	public void ternaryExpression(){
		System.out.println(4 > 5 ? "4大于于5" : "4小于5");
	}
	
	/**
	 * 
	 * (位运算符)
	 * 二进制运算符需要注意的两点：1、使用补码计算。2、结果为负时取结果补码，得到最后结果。
	 * @param  
	 * @return 
	 * @throws
	 */
	@Test
	public void bitOperation(){
		//&运算符(将10进制转换成2进制运算。二进制运算使用补码。同为1则为1,否则为0)
		//5 = (00101)2
		//9 = (01001)2
		System.out.println("5&9 = " + (5&9));
		System.out.println("-5&9 = " + (-5&9));
		//|运算符(有一个为1则为1，否则为0)
		System.out.println("5|9 = " + (5|9));
		System.out.println("-5|9 = " + (-5|9));
		//~运算符（全部取反，包括符号位）
		System.out.println("~-5 = " + ~-5);
		//^异或操作（相同则为0，不同为1）
		System.out.println("5^9 = " + (5^9));
		System.out.println("-5^9 = " + (-5^9));
		
		//<<左移运算符(将运算数的二进制码整体左移指定位数，左移后右边空出来的位用0填充)
		System.out.println("5 << 2 = " + (5 << 2));
		System.out.println("-5 << 2 = " + (-5 << 2));
		//>> 右移运算符和 >>>无符号右移运算符
		System.out.println("-5 >> 2 = " + (-5 >> 2));
		System.out.println("-5 >>> 2 = " + (-5 >>> 2));
	}
}
