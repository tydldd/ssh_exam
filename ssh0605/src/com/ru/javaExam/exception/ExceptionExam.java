/**
 * 文件名：ExceptionTest.java
 *
 * 版本信息：1.0
 * 日期：2013-7-1
 * Copyright ru Corporation 2013 版权所有
 *
 */
package com.ru.javaExam.exception;

import java.io.File;

import org.junit.Test;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：
 * 创建人：nanchengru
 * 创建时间：2013-7-1 上午09:44:13
 * 修改人：nanchengru
 * 修改时间：2013-7-1 上午09:44:13
 * 修改备注：
 * 环境：  jdk1.7
 */
@SuppressWarnings("serial")
class MyNullException extends Exception{
	public MyNullException(){super("空指针");}
	public MyNullException(String msg){super(msg);}
}

public class ExceptionExam {

	static int count = 0;
	
	/**
	 * 
	 * test(使用自定义异常需要：显示捕获，并抛出异常。)
	 * @param  
	 * @return 
	 * @throws
	 */
	@Test
	public void finallyWorks(){
		while(true){
			try {
				if(count++ == 0)
					throw new MyNullException();
				System.out.println("No Exception");
			} catch (Exception e) {
				System.out.println("MyNullException");
				e.printStackTrace();
			}finally{
				System.out.println("finally");
				if(count == 3){
					break;
				}
			}
		}
	}
	
	public static void test() throws MyNullException{
		String s = null;
		try {
			s.length();
		} catch (Exception e) {
			throw new MyNullException("空指针");
		}
	}
	
	
	public  static void main(String[] args){
		try {
			test();
		} catch ( MyNullException e) {
			
			e.printStackTrace();
			System.out.println(e.getStackTrace());
			System.out.println("e.getMessage=" + e.getMessage() + 
			"    e.getLocalizedMessage()" + e.getLocalizedMessage());
			
		}
	}
}
