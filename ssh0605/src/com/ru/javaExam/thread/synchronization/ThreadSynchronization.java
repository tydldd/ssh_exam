/**
 * 版本信息：Copyright ru Corporation 2013 
 * 版权所有
 *
 */
package com.ru.javaExam.thread.synchronization;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：线程同步(并发执行，线程不安全)
 * 创建人：成如
 * 创建时间：2013-9-2 下午4:45:34
 * 修改人：成如
 * 修改时间：2013-9-2 下午4:45:34
 * 修改备注：
 * @since jdk1.7
 * @version 1.0
 */
public class ThreadSynchronization implements Runnable{

	private Account account;
	private int draw;
	
	/**
	 * 创建一个新的实例 ThreadSynchronization.
	 *
	 * @param account
	 */
	public ThreadSynchronization(Account account,int draw) {
		super();
		this.account = account;
		this.draw = draw;
	}


	/* (方法重写)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		//（同步代码块）使用synchronized(obj){}对程序加锁，obj称为同步监视器
		synchronized(account){
			if(account.getDeposit() >= draw){
				System.out.println(Thread.currentThread().getName() + "取款成功");
				
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				account.setDeposit(account.getDeposit() - draw);
				
				System.out.println(Thread.currentThread().getName() + "的账户余额：" + account.getDeposit());
			}else{
				System.out.println(Thread.currentThread().getName() + "余额不足！");
			}
		}
		
		
	}
	
}
