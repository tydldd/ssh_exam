package com.ru.javaExam.exception;

import org.junit.Test;

/**
 * 项目名称：ssh0605
 * 类描述：
 * 创建人：ru
 * 创建时间：2013-8-9 下午02:41:47
 * 修改人：ru
 * 修改时间：2013-8-9 下午02:41:47
 * 修改备注：
 * @since  jdk1.7
 * @version 1.0
 */
public class PerformanceTest {
	
	@Test
	public void test(){
		int a = 0;
		long time1 = System.currentTimeMillis();
		for(int i = 0; i < 1000000000; i++){
			a++;
		}
		long time2 = System.currentTimeMillis();
		System.out.println(time2-time1);
		
		long time3 = System.currentTimeMillis();
		for(int i = 0; i < 1000000000; i++){
			try {
				a++;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		long time4 = System.currentTimeMillis();
		System.out.println(time4-time3);
		
	}
	
	@Test
	public void test2(){ 
		int a = 0;
		long time1 = System.currentTimeMillis();
		for(int i = 0; i < 1000000000; i++){
			a++;
		}
		long time2 = System.currentTimeMillis();
		System.out.println(time2-time1);
		
		long time3 = System.currentTimeMillis();
		try {
			for(int i = 0; i < 1000000000; i++){
			
				a++;
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		long time4 = System.currentTimeMillis();
		System.out.println(time4-time3);
		
	}
}
