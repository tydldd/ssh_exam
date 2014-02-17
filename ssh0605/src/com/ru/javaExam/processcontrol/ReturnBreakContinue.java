/**
 * 文件名：ReturnBreakContinue.java
 *
 * 版本信息：1.0
 * 日期：2013-6-27
 * Copyright ru Corporation 2013 版权所有
 *
 */
package com.ru.javaExam.processcontrol;

import org.junit.Test;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：
 * 创建人：nanchengru
 * 创建时间：2013-6-27 下午04:57:36
 * 修改人：nanchengru
 * 修改时间：2013-6-27 下午04:57:36
 * 修改备注：
 * 环境：  jdk1.7
 */
public class ReturnBreakContinue {
	
	/**
	 * 
	 * returnTest(return作用：1.退出当前方法2.返回值)
	 * @param  
	 * @return 
	 * @throws
	 */
	public void returnTest(){
		for(int i = 0; i < 10; i++){
			if(i == 3){
				return;
			}
			System.out.println(i);
		}
		System.out.println("return执行，将不会打印这一行");
	}
	
	/**
	 * 
	 * breakTest(break表示跳出当前循环，执行方法的其他部分)
	 * @param  
	 * @return 
	 * @throws
	 */
	public void breakTest(){
		for(int i = 0; i < 10; i++){
			if(i == 3){
				break;
			}
			System.out.println(i);
		}
		System.out.println("break执行，将打印这一行");
	}
	
	/**
	 * 
	 * continueTest(continue表示退出当前迭代，执行下次迭代)
	 * @param  
	 * @return 
	 * @throws
	 */
	public void continueTest(){
		for(int i = 0; i < 10; i++){
			if(i == 3){
				System.out.println("continue执行，将不打印  3  这一行");
				continue;
			}
			System.out.println(i);
		}
		
	}
	
	@Test
	public void test(){
		System.out.println("******************************");
		returnTest();
		System.out.println("******************************");
		breakTest();
		System.out.println("******************************");
		continueTest();
	}
}
