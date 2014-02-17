/**
 * 文件名：RedirectInAndOut.java
 *
 * 版本信息：
 * 日期：2013年11月5日
 * Copyright ru Corporation 2013 
 * 版权所有
 *
 */
package com.ru.javaExam.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：重定向输入输出流
 * 创建人：成如
 * 创建时间：2013年11月5日 上午11:08:49
 * 修改人：成如
 * 修改时间：2013年11月5日 上午11:08:49
 * 修改备注：
 * @since  jdk1.7
 * @version 1.0
 */
public class RedirectInAndOut {
	
	/**
	 * java标准输入输出使用System.in和System.out代表，默认情况下他们分别代表键盘和显示器
	 * 
	 * 通过System.setOut重定向输出流
	 * 通过System.setIn 将标准输入流重定向到文件输入流
	 * 
	 */
	static{
		try {
			System.setOut(new PrintStream("G:/log/redirectlog.log"));//重定向输出流
			System.setIn(new FileInputStream("G:/test/reader.java"));//将标准输入流重定向到文件输入流
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * redirectOut(重定向输出流测试方法)
	 * @return void
	 */
	public static void redirectOut(){
		System.out.println("输出重定向日志记录");
		System.out.println("第二行记录");
	}
	
	/**
	 * 
	 * redirectIn(重定向输入流测试)
	 * @return void
	 * @throws IOException 
	 */
	public static void redirectIn() throws IOException{
		FileInputStream fs = null;
		try {
			
			Scanner sc = new Scanner(System.in);
			
			sc.useDelimiter("\n");//将回车作为分隔符
			while(sc.hasNext()){
				String str = sc.next();
				System.out.println(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(fs != null){
				fs.close();
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		//redirectOut();
		redirectIn();
	}
}
