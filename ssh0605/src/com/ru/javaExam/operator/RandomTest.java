/**
 * 文件名：RandomTest.java
 *
 * 版本信息：1.0
 * 日期：2013-6-27
 * Copyright ru Corporation 2013 版权所有
 *
 */
package com.ru.javaExam.operator;

import java.util.Random;

import org.junit.Test;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：Random类（随机数）
 * 创建人：nanchengru
 * 创建时间：2013-6-27 下午02:56:47
 * 修改人：nanchengru
 * 修改时间：2013-6-27 下午02:56:47
 * 修改备注：
 * 环境：  jdk1.7
 */
public class RandomTest {
	
	@Test
	public void randomTest(){
		Random r = new Random();
		int i = r.nextInt(10);
		System.out.println(i);
	}
	
	public int returnInt1(int i){
		return i < 10 ? i * 10 : i;
	}
	
	public int returnInt2(int i){
		if(i < 10){
			return i*10;
		}else{
			return i;
		}
	}
	
	@Test
	public void test(){
		System.out.println(returnInt1(9));
		System.out.println(returnInt1(10));
		System.out.println(returnInt2(9));
		System.out.println(returnInt2(10));
	}
	
	
}
