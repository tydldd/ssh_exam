/**
 * 版本信息：Copyright ru Corporation 2013 
 * 版权所有
 *
 */
package com.ru.javaExam.thread.synchronization.synwaitnotify;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：
 * 创建人：成如
 * 创建时间：2013-9-3 下午3:49:36
 * 修改人：成如
 * 修改时间：2013-9-3 下午3:49:36
 * 修改备注：
 * @since jdk1.7
 * @version 1.0
 */
public class Test {

	@org.junit.Test
	public void test(){
		Account ac = new Account(123, 800, 800);
		OperateAccount oa1 = new OperateAccount(ac, "save");
		OperateAccount oa2 = new OperateAccount(ac, "draw");
		

		Thread th2 = new Thread(oa2,"取款者-");
		th2.start();
		
		Thread th1 = new Thread(oa1,"存款者-");
		th1.start();
		
	}
}
