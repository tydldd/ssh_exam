/**
 * 版本信息：Copyright ru Corporation 2013 
 * 版权所有
 *
 */
package com.ru.javaExam.keybordinput;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：
 * 创建人：成如
 * 创建时间：2013-10-5 下午10:02:18
 * 修改人：成如
 * 修改时间：2013-10-5 下午10:02:18
 * 修改备注：
 * @since jdk1.7
 * @version 1.0
 */
public class ScannerTest {

	/**
	 * 
	 * (读取输入的内容)
	 * @param  
	 * @return 
	 * @throws
	 */
	@Test
	public void test1(){
		Scanner sc = new Scanner(System.in);//实例化scanner以后就可以使用键盘输入
		
		//使用回车作为分隔符
		//sc.useDelimiter("\n");
		
		//使用next()方法可以输入字符串和数字(有一个next()就可以得到一个输入值,这里可以得到两个输入值，也只允许键盘输入两个值)
		if(sc.hasNext()){
			System.out.println("输入的是（1）：" + sc.next());
		}
		
		System.out.println("输入的是（2）：" + sc.next());
	}
	
	/**
	 * 
	 * (读取输入的数字)
	 * @param  
	 * @return 
	 * @throws
	 */
	//@Test
	public void testInt(){
		int i1 = 0;
		int i2 = 0;
		
		Scanner sc = new Scanner(System.in);
		
		//每一个nextInt()对应一次输入
		i1 = sc.nextInt();
		i2 = sc.nextInt();
		
		System.out.println("结果是：" + (i1 + i2));
	}
	
	/**
	 * @throws FileNotFoundException 
	 * 
	 * (读取文本内容)
	 * @param  
	 * @return 
	 * @throws
	 */
	public static void main(String[] args) throws FileNotFoundException{
		Scanner sc = new Scanner(new File("D:\\a.txt"));
		
		StringBuilder sb = new StringBuilder();
		
		while(sc.hasNextLine()){
			sb.append(sc.nextLine() + "\n");
			//System.out.println(sc.nextLine());
		}
		
		System.out.println(sb.toString());
	}
}
