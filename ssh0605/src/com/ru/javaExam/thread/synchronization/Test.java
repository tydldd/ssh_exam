/**
 * 版本信息：Copyright ru Corporation 2013 
 * 版权所有
 *
 */
package com.ru.javaExam.thread.synchronization;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：
 * 创建人：成如
 * 创建时间：2013-9-2 下午6:15:18
 * 修改人：成如
 * 修改时间：2013-9-2 下午6:15:18
 * 修改备注：
 * @since jdk1.7
 * @version 1.0
 */
public class Test {

	@org.junit.Test
	public void test(){
		Account ac = new Account(1234567, 1000);
		ThreadSynchronization ts = new ThreadSynchronization(ac, 800);
		
		Thread th = new Thread(ts, "甲");
		th.start();
		
		Thread th2 = new Thread(ts,"乙");
		th2.start();
	}
}
