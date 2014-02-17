/**
 * 文件名：StringReaderExam.java
 *
 * 版本信息：
 * 日期：2013年11月4日
 * Copyright ru Corporation 2013 
 * 版权所有
 *
 */
package com.ru.javaExam.io;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import jit.pms.CertificateStore.Test1;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：StringReader字符串作为作为字符流/StringWriter将字符串输出到文件
 * 创建人：成如
 * 创建时间：2013年11月4日 下午5:20:21
 * 修改人：成如
 * 修改时间：2013年11月4日 下午5:20:21
 * 修改备注：
 * @since  jdk1.7
 * @version 1.0
 */
public class StringReaderExam {
	
	/**
	 * 
	 * test1(使用String字符串得到字符流)
	 * @return void
	 */
	public static void stringReader(){
		String s = "12wr456";
		char[] buffer = new char[100];
		int len = 0;
		StringReader sr = new StringReader(s);
		try {
			while((len = sr.read(buffer)) != -1){
				System.out.println(new String(buffer, 0, len));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * stringWriter(StringWriter相当于StringBuffer)
	 * @return void
	 */
	public static void stringWriter(){
		
		/*StringBuilder sb = new StringBuilder();
		sb.append("这是一个StringWriter的测试方法\r\n");
		sb.append("现在输入第二行\r\n");*/
		
		StringWriter sw = new StringWriter();
		sw.write("这是一个StringWriter的测试方法\r\n");
		sw.write("现在输入第二行\r\n");
		
		System.out.println(sw.toString());
	}
	
	public static void main(String[] args){
		//stringReader();
		stringWriter();
	}
}
