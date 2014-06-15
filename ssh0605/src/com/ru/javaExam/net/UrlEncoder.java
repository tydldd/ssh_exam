package com.ru.javaExam.net;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.junit.Test;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：
 * 创建人：nange
 * 创建时间：2014年3月10日 下午3:19:17
 * 修改人：nange
 * 修改时间：2014年3月10日 下午3:19:17
 * 修改备注：
 * @since  jdk1.7
 * @version 1.0
 */
public class UrlEncoder {

	//使用urlencoder将普通字符串转变成x-www-form-urlencod的mime字符串
	@Test
	public void test1() throws UnsupportedEncodingException{
		String bookName = "hadoop开发实战";
		System.out.println("" + bookName + " --> " + URLEncoder.encode(bookName, "UTF-8"));
	}
	
	//将x-www-form-urlencod的mime字符串转换成普通字符串
	@Test
	public void test2() throws UnsupportedEncodingException{
		String bookName2 = "hadoop%E5%BC%80%E5%8F%91%E5%AE%9E%E6%88%98";
		System.out.println(bookName2 + " -->  " + URLDecoder.decode(bookName2, "UTF-8"));
	}
}
