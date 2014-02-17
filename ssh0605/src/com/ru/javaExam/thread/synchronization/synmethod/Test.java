/**
 * 版本信息：Copyright ru Corporation 2013 
 * 版权所有
 *
 */
package com.ru.javaExam.thread.synchronization.synmethod;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：
 * 创建人：成如
 * 创建时间：2013-9-3 上午10:23:25
 * 修改人：成如
 * 修改时间：2013-9-3 上午10:23:25
 * 修改备注：
 * @since jdk1.7
 * @version 1.0
 */
public class Test {

	@org.junit.Test
	public void test(){
		Account ac = new Account(123, 1000, 800);
		
		Thread th1 = new Thread(ac, "甲");
		th1.start();
		
		Thread th2 = new Thread(ac, "乙");
		th2.start();
	}
}
