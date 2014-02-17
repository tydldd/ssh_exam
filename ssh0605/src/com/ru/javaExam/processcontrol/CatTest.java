/**
 * 文件名：CatTest.java
 *
 * 版本信息：1.0
 * 日期：2013-6-28
 * Copyright ru Corporation 2013 版权所有
 *
 */
package com.ru.javaExam.processcontrol;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：不用花括号的危险
 * 创建人：nanchengru
 * 创建时间：2013-6-28 下午04:38:21
 * 修改人：nanchengru
 * 修改时间：2013-6-28 下午04:38:21
 * 修改备注：
 * 环境：  jdk1.7
 */
                                                        
class Cats{
	private static int count = 0;
	public Cats(){
		System.out.println("调用cat的无参构造函数");
		count++;
	}
	public static int getCunt(){
		return count;
	}
}

public class CatTest {
	
	/**
	 * 
	 * main(for、while、do while循环中的重复执行语句不能是一条单独的局部变量定义语句)
	 * @param  
	 * @return 
	 * @throws
	 */
	public static void main(String[] args){
		for(int i = 0; i < 10; i++){
			Cats cat = new Cats();
		}
		System.out.println(Cats.getCunt());	
	}
	
}
